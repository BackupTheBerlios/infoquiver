
package net.sf.iquiver.om.cache;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sf.iquiver.om.ContentSourceTransportConfig;
import net.sf.iquiver.util.om.CacheBackedPeer;
import net.sf.swarmcache.ObjectCache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Criteria;

import de.netseeker.util.ArrayUtil;

/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Mon Jul 12 14:25:30 CEST 2004]
 * Template used for generation: CacheBackedPeer.vm
 *
 * These generated peer classes provide a non-manager based, cluster aware cache
 * solution for Torque (http://db.apache.org/torque) based on swarm cache (http://swarmcache.sourceforge.net)
 *
 */
public abstract class CacheBackedContentSourceTransportConfigPeer
    extends net.sf.iquiver.om.BaseContentSourceTransportConfigPeer
{
	final public static String CACHE_KEY;

	private static Log logger;
	
	private static boolean useCache;
	private static ObjectCache cache;
	
	private static boolean cacheCriteriaSelects = false;
	private static ObjectCache criteriaIdListCache;
	
	private static Criteria clear_crit;

	/**
     * Static class constructor:<br>
     * Enables or disables the caching for this peer according to the configuration
	 * in de.dat.dat.framework.util.om.CacheBackedPeer
     */	
	static
	{
		logger = LogFactory.getLog(CacheBackedContentSourceTransportConfigPeer.class);
		CACHE_KEY = "net.sf.iquiver.om.om.ContentSourceTransportConfig";
		useCache = false;
		clear_crit = new Criteria();

		if(CacheBackedPeer.isEnabledAtStartup())
		{
    		if(CacheBackedPeer.getExcludeEnableAtStartUp() != null && !ArrayUtil.containsMatchingRegExString(CacheBackedPeer.getExcludeEnableAtStartUp(), "net.sf.iquiver.om.ContentSourceTransportConfigPeer"))
    		{
				enableCache(true);
        	    if(CacheBackedPeer.isEnableCacheForCriteriaSelects())
        	    {
        	    	if(CacheBackedPeer.getExcludeEnableCacheForCriteriaSelects() != null)
    				{
    					enableCacheForCriteriaSelects(!ArrayUtil.containsMatchingRegExString(CacheBackedPeer.getExcludeEnableCacheForCriteriaSelects(), "net.sf.iquiver.om.ContentSourceTransportConfigPeer"));
    				}
    				else
    				{
    					enableCacheForCriteriaSelects(true);
    				}
        	    }				
    		}    
		}
	}
		
    /**
     * Enables or disables the underlying object cache.<br>
     * The cache is disabled by default, so you have to call this method once to enable caching.     
     * @param enable
     */	
	public static synchronized void enableCache(boolean enable)
	{
		if(enable && !isCacheEnabled())
		{
			try
			{
				cache = getCacheFactory().createCache(CACHE_KEY);
				useCache = true;
				logger.debug("Cache enabled");			
			}
			catch (NullPointerException ne)
			{
				logger.error("CACHFACTORY NOT INSTANTIATED - Cache still disabled");
			}
		}
		else if(!enable && isCacheEnabled())
		{
			if(isCacheForCriteriaSelectsEnabled())
			{
				logger.debug("CriteriaResultListCache is active, will disable it now");
				enableCacheForCriteriaSelects(false);
			}
			
			useCache = false;
			logger.debug("Cache is shutting down");

			new Thread()
			{					
				public void run()
				{
					try
	                {
						//delay a little bit to allow all current running cache activities to complete
	                    Thread.sleep(1000);
	                }
	                catch ( InterruptedException e )
	                {
	                    logger.error("Waiting for 1000ms to allow cache activities to complete FAILED. This may result in critical errors.");
	                }

					nullifyCache();
					logger.debug("Cache disabled");
				}
			}.start();

			logger.debug("Cache disabled");			
		}		
	}
	
    /**
     * Indicates if the underlying object cache is active or not.
     * @return true if underlying object cache is active, otherwise false
     */
	public static boolean isCacheEnabled()
	{
		return useCache;
	}
	
    /**
     * Enables or disables the caching mechanism for caching results of <code>doSelect(Criteria)</code>.<br>
     * Caching of such results is much more complicated than caching results of single selects:<br>
     * A second cache - which will store a list of primary keys for each criteria - will be created.<br>
     * Each call of <code>doSelect(Criteria)</code> will generate a list of primary keys of the retrieved objects<br>
     * (one ObjectKey for each object) and store this list in a CriteriaResultListCache.<br>
     * Then all retrieved objects will be stored in the main object cache in the same manner as they would be stored<br>
     * by single selects.<br>
     * Retrieving of object lists with a given criteria is slower than processing a bunch of single selects<br>
     * from outside of a peer.<br>
     * This is caused by the overhead of processing the required list of primary keys stored in<br>
     * CriteriaResultListCache to retrieve the corresponding cached objects from the main object cache.<br>
     * More information on caching of torque generated objects can be found on the homepage of Torque.
     * @link http://db.apache.org/torque/managers-cache.html
     * @param enable
     * @throws IllegalStateException if the required main object cache is not enabled
     */
	public static synchronized void enableCacheForCriteriaSelects(boolean enable) throws IllegalStateException
	{
		if(isCacheEnabled())
		{
			if(enable && !isCacheForCriteriaSelectsEnabled())
			{
				criteriaIdListCache = getCacheFactory().createCache(CACHE_KEY + ".CriteriaIdList");
				cacheCriteriaSelects = true;
				logger.debug("CriteriaResultListCache enabled");
			}
			else if(!enable && isCacheForCriteriaSelectsEnabled())
			{
				cacheCriteriaSelects = false;
				logger.debug("CriteriaResultListCache is shutting down");
				new Thread()
				{					
					public void run()
					{
						try
		                {
							//delay a little bit to allow all current running cache activities to complete
		                    Thread.sleep(1000);
		                }
		                catch ( InterruptedException e )
		                {
		                    logger.error("Waiting for 1000ms to allow cache activities to complete FAILED. This may result in critical errors.");
		                }

						nullifyCriteriaResultListCache();
						logger.debug("CriteriaResultListCache disabled");
					}
				}.start();
			}
		}
		else
		{
			throw new IllegalStateException("Object cache is disabled. You must enable the object cache via enableCache(true) before the criteria cache can be used.");
		}		
	}
	
	private static synchronized void nullifyCache()
	{
		cache = null;
	}

	private static synchronized void nullifyCriteriaResultListCache()
	{
		criteriaIdListCache = null;
	}
	
    /**
     * Indicates if the underlying CriteriaResultListCache is active or not.
     * @return true if underlying CriteriaResultListCache is active, otherwise false
     * @see enableCacheForCriteriaSelects(boolean enable)
     */
	public static boolean isCacheForCriteriaSelectsEnabled()
	{
		return cacheCriteriaSelects;
	}
	
	private static ContentSourceTransportConfig getObjectFromCache(ContentSourceTransportConfig obj)
	{		
		ContentSourceTransportConfig tmpObj = null;		
		ObjectKey key = obj.getPrimaryKey();
		try
		{
			tmpObj = getObjectFromCache(key);
		}
		catch(IllegalArgumentException e)
		{
			logger.warn(e);
		}
		
		return tmpObj;
	}
	
	private static ContentSourceTransportConfig getObjectFromCache(ObjectKey key) throws IllegalArgumentException
	{
		ContentSourceTransportConfig tmpObj = null;
		
		if(isCacheEnabled())
		{
			if (key != null && key.getValue() != null)
			{
				try
				{
					tmpObj = (ContentSourceTransportConfig)cache.get(key);
				}
				catch(NullPointerException ne)
				{
					logger.error("!!!Obviously the cache got disabled by a concurrent thread during the request.!!!");
				}
			}
			else
			{
				throw new IllegalArgumentException("Invalid Object key provided. The key was: " + key);
			}
		}
		
		return tmpObj;
	}

	private static void addObjectToCache(ObjectKey key, ContentSourceTransportConfig obj)
	{
		if(isCacheEnabled() && key != null && key.getValue() != null && obj != null)
		{
			cache.put(key, obj);
		}
	}
	
	private static void removeObjectFromCache(ObjectKey key)
	{
		if(isCacheEnabled() && key != null && key.getValue() != null)
		{
			cache.clear(key);
		}
	}
		
	private static void addCriteriaResultListToCache(Criteria criteria, List objects)
	{
		List idList = new ArrayList();
		
		for(Iterator it = objects.iterator(); it.hasNext();)
		{
			ContentSourceTransportConfig obj = (ContentSourceTransportConfig)it.next();
			ObjectKey key = obj.getPrimaryKey();
			idList.add(key);
			addObjectToCache(key, obj);			
		}
		
		if(!idList.isEmpty())
		{
			criteriaIdListCache.put(criteria, idList);
		}
	}
	
	private static void removeCriteriaResultListFromCache(final Criteria criteria)
	{		
		new Thread()
		{
			public void run()
			{
				List idList = (List)criteriaIdListCache.get(criteria);
				if(idList != null)
				{
					criteriaIdListCache.clear(criteria);
					for(Iterator it = idList.iterator(); it.hasNext();)
					{
						ObjectKey key = (ObjectKey)it.next();
						cache.clear(key);
					}
				}
			}
		}.start();
	}
	
	private static List getObjectsFromCache(Criteria crit)
	{
		List objects = new ArrayList();
		List idList = (List)criteriaIdListCache.get(crit);
		if(idList != null)
		{
			for(Iterator it = idList.iterator(); it.hasNext();)
			{
				Object obj = cache.get((Serializable)it.next());
				if(obj != null)
				{
					objects.add(obj);
				}
			}
		}
		
		return objects;
	}
	
    /**
	 * Completes a partially populated ContentSourceTransportConfig object by fetching the missing values from the database.<br>
	 * If the complete ContentSourceTransportConfig is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched object to the cache	 
     * @param obj A partially populated ContentSourceTransportConfig. <code>obj</code> will not be changed, this method returns a new object instead.
     * @return a ContentSourceTransportConfig object containing all values available in the database.
     * @throws TorqueException
     */	 
	public static ContentSourceTransportConfig doSelectSingle(ContentSourceTransportConfig obj) throws TorqueException
	{			
		ContentSourceTransportConfig tmpObj = getObjectFromCache(obj);
		
		if(tmpObj == null)
		{
			List objList = net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doSelect(obj);
			if(objList != null && !objList.isEmpty())
			{
				tmpObj = (ContentSourceTransportConfig)objList.get(0);
				if(tmpObj != null)
				{
					addObjectToCache(tmpObj.getPrimaryKey(), tmpObj);
				}
			}
		}
		
		return tmpObj;
	}

    /**
	 * Fetches a list of ContentSourceTransportConfigs by a partially populated ContentSourceTransportConfig object from the database.<br>
	 * If the result list is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched list of objects to the cache	 
     * @param obj A partially populated ContentSourceTransportConfig. <code>obj</code> will not be changed, this method returns a new object instead.
     * @return a ContentSourceTransportConfig object containing all values available in the database.
     * @throws TorqueException
     */	 
	public static List doSelect(ContentSourceTransportConfig obj) throws TorqueException
	{			
		return doSelect(buildCriteria(obj));
	}
		
    /**
     * Fetches a list of ContentSourceTransportConfigs from the database by a given criteria<br>
	 * If the CriteriaResultListCache is enabled and the list of objects id already stored<br>
	 * in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache	 
     * @param crit
     * @return a list of ContentSourceTransportConfigs fetched from the database or cache
     * @throws TorqueException
     */	
	public static List doSelect(final Criteria crit) throws TorqueException
	{
        Connection db = null;
        List retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = doSelect(crit, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return(retVal);
	}

    /**
     * Fetches a list of ContentSourceTransportConfigs from the database by a given criteria<br>
	 * If the CriteriaResultListCache is enabled and the list of objects id already stored<br>
	 * in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache<br>
     * This method uses a existing Transaction               
     * @param crit
     * @return a list of ContentSourceTransportConfigs fetched from the database or cache
     * @throws TorqueException
     */	
	public static List doSelect(final Criteria crit, Connection con) throws TorqueException
	{
		List results = null;

		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{
			getObjectsFromCache(crit);
		}
		
		if(results == null || results.isEmpty())
		{
			results = net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doSelect(crit, con);
		
	        if(results != null && isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
	        {
		        //adding all retrieved objects to cache
				addCriteriaResultListToCache(crit, results);
			}
		}
		
		return results;
	}		
	
    /**
     * Fetches all ContentSourceTransportConfigs from the database<br>
	 * If the objects are already stored in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache	 
     * @param crit
     * @return a list of ContentSourceTransportConfigs fetched from the database or cache
     * @throws TorqueException
     */	
	public static List doSelectAll() throws TorqueException
	{
        Connection db = null;
        List retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = doSelectAll(db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return(retVal);

	}			

    /**
     * Fetches all ContentSourceTransportConfigs from the database<br>
	 * If the objects are already stored in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache	 
     * @param crit
     * @return a list of ContentSourceTransportConfigs fetched from the database or cache
     * @throws TorqueException
     */	
	public static List doSelectAll(Connection con) throws TorqueException
	{
		return doSelect(clear_crit, con);
	}			


    
    
    /**
     * Fetches a ContentSourceTransportConfig from the database by a given primary key<br>
	 * If the ContentSourceTransportConfig is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched object to the cache	 
     * @param key The primary key of the desired ContentSourceTransportConfig
     * @return a ContentSourceTransportConfig fetched from the database or cache
     * @throws TorqueException
     */	
	public static ContentSourceTransportConfig retrieveByPK(ObjectKey key) throws TorqueException
	{
		ContentSourceTransportConfig obj = getObjectFromCache(key);
		
		if(obj == null)
		{
			obj = net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.retrieveByPK(key);
			addObjectToCache(key, obj);
		}
		
		return obj;	
	}

    /**
     * Fetches a ContentSourceTransportConfig from the database by a given primary key<br>
	 * If the ContentSourceTransportConfig is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched object to the cache	 
     * This method uses a existing Transaction          
     * @param key The primary key of the desired ContentSourceTransportConfig
     * @param con An existing connection
     * @return a ContentSourceTransportConfig fetched from the database or cache
     * @throws TorqueException
     */	
	public static ContentSourceTransportConfig retrieveByPK(ObjectKey key, Connection con) throws TorqueException
	{
		ContentSourceTransportConfig obj = getObjectFromCache(key);
		
		if(obj == null)
		{
			obj = net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.retrieveByPK(key, con);
			addObjectToCache(key, obj);
		}
		
		return obj;	
	}
	
    /**
     * Fetches multiple ContentSourceTransportConfigs from the database by a given list of primary keys<br>
	 * If the list of primary keys is already stored in the CriteriaResultListCache, the cached objects will be returned<br>
     * As the case may be this method will add the fetched list objects to the cache	 
     * @param pks The list of primary keys
     * @return a list of ContentSourceTransportConfigs fetched from the database or cache
     * @throws TorqueException
     */	
    public static List retrieveByPKs(List pks) throws TorqueException
    {
        Connection db = null;
        List retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = retrieveByPKs(pks, db);
        }
        finally
        {
            Torque.closeConnection(db);
        }
        return(retVal);
    }
    
    /**
     * Fetches multiple ContentSourceTransportConfigs from the database by a given list of primary keys<br>
	 * If the list of primary keys is already stored in the CriteriaResultListCache, the cached objects will be returned<br>
     * As the case may be this method will add the fetched list objects to the cache	 
     * This method uses a existing Transaction          
     * @param pks The list of primary keys
     * @param dbcon An existing connection     
     * @return a list of ContentSourceTransportConfigs fetched from the database or cache
     * @throws TorqueException
     */	
    public static List retrieveByPKs( List pks, Connection dbcon ) throws TorqueException
    {
        List objs = null;
        if (pks == null || pks.size() == 0)
        {
            objs = new LinkedList();
        }
        else
        {
            Criteria criteria = new Criteria();
              Iterator iter = pks.iterator();
            while (iter.hasNext())
            {
                ObjectKey pk = (ObjectKey)iter.next();
                SimpleKey[] keys = (SimpleKey[])pk.getValue();
                            Criteria.Criterion c0 = criteria.getNewCriterion(
                        CONTENT_SOURCE_ID, keys[0], Criteria.EQUAL);
                                    Criteria.Criterion c1 = criteria.getNewCriterion(
                        TRANSPORT_ATTRIBUTE_ID, keys[1], Criteria.EQUAL);
                                    c0.and(c1);
                          criteria.or(c0);
            }
          objs = doSelect(criteria, dbcon);
        }
        
        return objs;
    }



	    /**
     * Fetches a ContentSourceTransportConfig by it's primary key members from database or cache<br>
     * As the case may be this method will add the fetched object to the cache
		 * @param contentsourceid
			 * @param transportattributeid
		     * @param Connection con	
     * @return a ContentSourceTransportConfig fetched from the database or cache
     * @throws TorqueException
     */		    
	    public static ContentSourceTransportConfig retrieveByPK(
   			long contentsourceid	, 			int transportattributeid			) throws TorqueException
    {
        Connection db = null;
        ContentSourceTransportConfig retVal = null;
        try
        {
           db = Torque.getConnection(DATABASE_NAME);
           retVal = retrieveByPK(
         contentsourceid
          , transportattributeid
                     , db);
        }
        finally
        {
            Torque.closeConnection(db);
        }

        return(retVal);    	
	}
	
	    /**
     * Fetches a ContentSourceTransportConfig by it's primary key members from database or cache<br>
     * As the case may be this method will add the fetched object to the cache
		 * @param contentsourceid
			 * @param transportattributeid
		     * @param Connection con	
     * @return a ContentSourceTransportConfig fetched from the database or cache
     * @throws TorqueException
     */		    
	    public static ContentSourceTransportConfig retrieveByPK(
   			long contentsourceid	, 			int transportattributeid		       ,Connection con) throws TorqueException
    {
		ContentSourceTransportConfig obj = null;
		
					SimpleKey[] sKeys = new SimpleKey[]{
		   					SimpleKey.keyFor(contentsourceid) , 							SimpleKey.keyFor(transportattributeid) 						};
	
			ComboKey oKey = new ComboKey(sKeys);
		
		return retrieveByPK(oKey);
    }


    /**
     * Deletes an ContentSourceTransportConfig in the database, if the ContentSourceTransportConfig is already stored in the object cache,<br>
     * it will be removed
     * @param obj
     * @throws TorqueException
     */
	public static void doDelete(ContentSourceTransportConfig obj) throws TorqueException
	{		
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(obj);
		removeObjectFromCache(obj.getPrimaryKey());		
	}

    /**
     * Deletes an ContentSourceTransportConfig in the database, if the ContentSourceTransportConfig is already stored in the object cache,<br>
     * it will be removed<br>
     * This method uses a existing Transaction
     * @param obj
     * @throws TorqueException
     */
	public static void doDelete(ContentSourceTransportConfig obj, Connection con) throws TorqueException
	{
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(obj, con);
		removeObjectFromCache(obj.getPrimaryKey());		
	}
	
    /**
     * Deletes one or more ContentSourceTransportConfigs in the database.<br>
     * If the CriteriaResultListCache is enabled and does contain an list of primary keys for the given criteria, the idList<br>
     * will get removed from the CriteriaResultListCache and also the corresponding ContentSourceTransportConfigs will be removed<br>
     * from the main object cache
     * @param crit
     * @throws TorqueException
     */
	public static void doDelete(final Criteria crit) throws TorqueException
	{
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(crit);

		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{		
			removeCriteriaResultListFromCache(crit);
		}				
	}		

    /**
     * Deletes one or more ContentSourceTransportConfigs in the database.
     * If the CriteriaResultListCache is enabled and does contain an list of primary keys for the given criteria, the idList<br>
     * will get removed from the CriteriaResultListCache and also the corresponding ContentSourceTransportConfigs will be removed<br>
     * from the main object cache<br>
     * This method uses a existing Transaction     
     * @param crit
     * @throws TorqueException
     */
	public static void doDelete(final Criteria crit, Connection con) throws TorqueException
	{
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(crit, con);
		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{
			removeCriteriaResultListFromCache(crit);
		}
	}

    /**
     * Deletes an ContentSourceTransportConfig in the database by a given primary key<br>
     * If the ContentSourceTransportConfig is already stored in the object cache, it will be removed
     * @param key
     * @throws TorqueException
     */	
	public static void doDelete(ObjectKey key) throws TorqueException
	{
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(key);		
		removeObjectFromCache(key);				
	}		

    /**
     * Deletes an ContentSourceTransportConfig in the database by a given primary key<br>
     * If the ContentSourceTransportConfig is already stored in the object cache, it will be removed<br>
     * This method uses a existing Transaction          
     * @param key
     * @throws TorqueException
     */	
	public static void doDelete(ObjectKey key, Connection con) throws TorqueException
	{
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(key, con);			
		removeObjectFromCache(key);
	}		
	
	    /**
     * Deletes an ContentSourceTransportConfig in the database by a given primary key<br>
     * If the ContentSourceTransportConfig is already stored in the object cache, it will be removed
		 * @param contentsourceid
			 * @param transportattributeid
		     * @throws TorqueException
     */		    
	    public static void doDelete(
   			long contentsourceid	, 			int transportattributeid		    ) throws TorqueException
    {
		Criteria crit = new Criteria();
				
	   				crit.add(CONTENT_SOURCE_ID, contentsourceid);
					crit.add(TRANSPORT_ATTRIBUTE_ID, transportattributeid);
				doDelete(crit);
		
		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{		
							SimpleKey[] sKeys = new SimpleKey[]{
			   						SimpleKey.keyFor(contentsourceid) , 									SimpleKey.keyFor(transportattributeid) 								};
		
				ComboKey oKey = new ComboKey(sKeys);
						
			removeObjectFromCache(oKey);
		}		
    }    

	    /**
     * Deletes an ContentSourceTransportConfig in the database by a given primary key<br>
     * If the ContentSourceTransportConfig is already stored in the object cache, it will be removed<br>
     * This method uses a existing Transaction               
		 * @param contentsourceid
			 * @param transportattributeid
		     * @throws TorqueException
     */		    
	    public static void doDelete(
   			long contentsourceid	, 			int transportattributeid				, Connection con) throws TorqueException
	{
		Criteria crit = new Criteria();
	   				crit.add(CONTENT_SOURCE_ID, contentsourceid);
					crit.add(TRANSPORT_ATTRIBUTE_ID, transportattributeid);
				net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doDelete(crit, con);
		
		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{		
							SimpleKey[] sKeys = new SimpleKey[]{
			   						SimpleKey.keyFor(contentsourceid) , 									SimpleKey.keyFor(transportattributeid) 								};
		
				ComboKey oKey = new ComboKey(sKeys);
						
			removeObjectFromCache(oKey);
		}				
    }    
    /**
     * Inserts or updates an ContentSourceTransportConfig obj in the database<br>
     * As the case may be this method will add the fetched object to the cache (insert)<br>
     * or updates the object in the cache (update)
     * @param obj
     * @throws TorqueException
     */
	public static void doInsert(ContentSourceTransportConfig obj) throws TorqueException
	{		
		removeObjectFromCache(obj.getPrimaryKey());
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doInsert(obj);
		if(obj != null)
		{
			addObjectToCache(obj.getPrimaryKey(), obj);		
		}
	}	

    /**
     * Inserts or updates an ContentSourceTransportConfig obj in the database<br>
     * As the case may be this method will add the fetched object to the cache (insert)<br>
     * or updates the object in the cache (update)<br>
     * This method uses a existing Transaction                    
     * @param obj
     * @throws TorqueException
     */
	public static void doInsert(ContentSourceTransportConfig obj, Connection con) throws TorqueException
	{
		removeObjectFromCache(obj.getPrimaryKey());
		net.sf.iquiver.om.BaseContentSourceTransportConfigPeer.doInsert(obj, con);
		if(obj != null)
		{
			addObjectToCache(obj.getPrimaryKey(), obj);		
		}
	}		
}
