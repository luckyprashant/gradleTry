package com.jetblue.api.mask;

import static com.jetblue.api.constant.AppConstant.MASKING_CHAR;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.jayway.jsonpath.Configuration;
import com.jayway.jsonpath.DocumentContext;
import com.jayway.jsonpath.JsonPath;
import com.jayway.jsonpath.Option;
import com.jayway.jsonpath.ParseContext;

/**
 * The Class ApplicationMasker.
 */
@Component
public class ApplicationMasker {

	private final Collection<JsonPath> masks = new LinkedList<JsonPath>();

	private final ParseContext parseContext;

	/**
	 * Instantiates a new application masker.
	 *
	 * @param configuration
	 *            the configuration
	 */
	@Autowired
	public ApplicationMasker(final ApplicationMaskConfig configuration) {
		for (String mask : configuration.getMasks()) {
			masks.add(JsonPath.compile(mask));
		}
		Configuration conf = Configuration.builder()
				.options(Option.ALWAYS_RETURN_LIST, Option.SUPPRESS_EXCEPTIONS, Option.AS_PATH_LIST).build();
		parseContext = JsonPath.using(conf);
	}

	/**
	 * Perform the masking.
	 *
	 * @param json
	 *            the JSON object to mask elements in
	 * @return the JSON with the selected elements masked
	 */
	public String mask(final String json) {
		String jsonObject = json;
		DocumentContext context = parseContext.parse(jsonObject);
		DocumentContext jsonContext = JsonPath.parse(jsonObject);
		// masks.stream().forEach(mask -> {
		// List<String> pathList = context.read(mask);
		// Optional<String> findFirst = pathList.stream().filter(path ->
		// isPathEmail(path)).findFirst().map(value -> context.set(path,
		// maskEmail(value, path)));
		// if(findFirst.isPresent()) {
		// context.set(path, maskEmail(value, path));
		// }
		// });
		for (JsonPath mask : masks) {
			List<String> pathList = context.read(mask);
			for (String path : pathList) {
				String value = jsonContext.read(path);
				if (isPathEmail(path)) {
					context.set(path, maskEmail(value, path));
					continue;
				}

				int length = value.length();
				String maskString = StringUtils.repeat(MASKING_CHAR, length);
				context.set(path, maskString);
			}
		}
		return context.jsonString();
	}

	/**
	 * Mask email.
	 * 
	 * @param context
	 * @param path2
	 *            the context
	 * @return the string
	 */
	private String maskEmail(String value, final String path) {
		String[] split = StringUtils.split(value, "@");
		String firstHalf = split[0];
		int length = firstHalf.length();
		String maskString = StringUtils.repeat(MASKING_CHAR, length);
		return (maskString + "@" + split[1]);
	}

	private boolean isPathEmail(String path) {
		return StringUtils.contains(path, "email");
	}

}
