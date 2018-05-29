//package com.jetblue.api.config;
//
//import org.springframework.cache.CacheManager;
//import org.springframework.cache.annotation.CachingConfigurer;
//import org.springframework.cache.annotation.EnableCaching;
//import org.springframework.cache.ehcache.EhCacheCacheManager;
//import org.springframework.cache.interceptor.CacheErrorHandler;
//import org.springframework.cache.interceptor.CacheResolver;
//import org.springframework.cache.interceptor.KeyGenerator;
//import org.springframework.cache.interceptor.SimpleCacheErrorHandler;
//import org.springframework.cache.interceptor.SimpleCacheResolver;
//import org.springframework.cache.interceptor.SimpleKeyGenerator;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//import net.sf.ehcache.config.CacheConfiguration;
//
///**
// * The Class CachingConfig.
// */
//@Configuration
//@EnableCaching
//public class CachingConfig implements CachingConfigurer {
//
//	/**
//	 * Eh cache manager.
//	 *
//	 * @return the net.sf.ehcache. cache manager
//	 */
//	@Bean(destroyMethod = "shutdown")
//	public net.sf.ehcache.CacheManager ehCacheManager() {
//		CacheConfiguration nearestAirportCacheConfig = new CacheConfiguration();
//		nearestAirportCacheConfig.setName("nearestAirport");
//		nearestAirportCacheConfig.setMemoryStoreEvictionPolicy("LRU");
//		nearestAirportCacheConfig.setMaxEntriesLocalHeap(200);
//		
//		CacheConfiguration airportCsvCacheConfig = new CacheConfiguration();
//		airportCsvCacheConfig.setName("airportCsv");
//		airportCsvCacheConfig.setMemoryStoreEvictionPolicy("LRU");
//		airportCsvCacheConfig.setMaxEntriesLocalHeap(200);
//
//		net.sf.ehcache.config.Configuration config = new net.sf.ehcache.config.Configuration();
//		config.addCache(nearestAirportCacheConfig);
//		config.addCache(airportCsvCacheConfig);
//		return net.sf.ehcache.CacheManager.newInstance(config);
//	}
//
//	
//	/* (non-Javadoc)
//	 * @see org.springframework.cache.annotation.CachingConfigurer#cacheManager()
//	 */
//	@Bean
//	@Override
//	public CacheManager cacheManager() {
//		return new EhCacheCacheManager(ehCacheManager());
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.cache.annotation.CachingConfigurer#keyGenerator()
//	 */
//	@Bean
//	@Override
//	public KeyGenerator keyGenerator() {
//		return new SimpleKeyGenerator();
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.cache.annotation.CachingConfigurer#cacheResolver()
//	 */
//	@Bean
//	@Override
//	public CacheResolver cacheResolver() {
//		return new SimpleCacheResolver();
//	}
//
//	/* (non-Javadoc)
//	 * @see org.springframework.cache.annotation.CachingConfigurer#errorHandler()
//	 */
//	@Bean
//	@Override
//	public CacheErrorHandler errorHandler() {
//		return new SimpleCacheErrorHandler();
//	}
//}