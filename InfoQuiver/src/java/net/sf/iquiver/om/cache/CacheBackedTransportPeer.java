
package net.sf.iquiver.om.cache;

import java.io.Serializable;
import java.sql.Connection;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

import net.sf.iquiver.om.Transport;
import net.sf.iquiver.util.om.CacheBackedPeer;
import net.sf.swarmcache.ObjectCache;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.util.Criteria;

import de.netseeker.util.ArrayUtil;

/**
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Mon Jun 28 22:47:06 CEST 2004]
 * Template used for generation: CacheBackedPeer.vm
 *
 * These generated peer classes provide a non-manager based, cluster aware cache
 * solution for Torque (http://db.apache.org/torque) based on swarm cache (http://swarmcache.sourceforge.net)
 *
 *  You should add additional methods to this class to meet the
 *  application requirements.  This class will only be generated as
 *  long as it does not already exist in the output directory.
 */
public abstract class CacheBackedTransportPeer
    extends net.sf.iquiver.om.BaseTransportPeer
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
		logger = LogFactory.getLog(CacheBackedTransportPeer.class);
		CACHE_KEY = "${targetDBOPackage}.torque.${databaseName}.om.Transport";
		useCache = false;
		clear_crit = new Criteria();

		if(CacheBackedPeer.isEnabledAtStartup())
		{
    		if(CacheBackedPeer.getExcludeEnableAtStartUp() != null && !ArrayUtil.containsMatchingRegExString(CacheBackedPeer.getExcludeEnableAtStartUp(), "de.dat.u3.db.dbo.torque.cd.om.TransportPeer"))
    		{
				enableCache(true);
        	    if(CacheBackedPeer.isEnableCacheForCriteriaSelects())
        	    {
        	    	if(CacheBackedPeer.getExcludeEnableCacheForCriteriaSelects() != null)
    				{
    					enableCacheForCriteriaSelects(!ArrayUtil.containsMatchingRegExString(CacheBackedPeer.getExcludeEnableCacheForCriteriaSelects(), "de.dat.u3.db.dbo.torque.cd.om.TransportPeer"));
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
				logger.info("Cache enabled");			
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
				logger.info("CriteriaResultListCache is active, will disable it now");
				enableCacheForCriteriaSelects(false);
			}
			
			useCache = false;
			logger.info("Cache is shutting down");

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
					logger.info("Cache disabled");
				}
			}.start();

			logger.info("Cache disabled");			
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
				logger.info("CriteriaResultListCache enabled");
			}
			else if(!enable && isCacheForCriteriaSelectsEnabled())
			{
				cacheCriteriaSelects = false;
				logger.info("CriteriaResultListCache is shutting down");
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
						logger.info("CriteriaResultListCache disabled");
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
	
	private static Transport getObjectFromCache(Transport obj)
	{		
		Transport tmpObj = null;		
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
	
	private static Transport getObjectFromCache(ObjectKey key) throws IllegalArgumentException
	{
		Transport tmpObj = null;
		
		if(isCacheEnabled())
		{
			if (key != null && key.getValue() != null)
			{
				try
				{
					tmpObj = (Transport)cache.get(key);
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

	private static void addObjectToCache(ObjectKey key, Transport obj)
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
			Transport obj = (Transport)it.next();
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
	 * Completes a partially populated Transport object by fetching the missing values from the database.<br>
	 * If the complete Transport is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched object to the cache	 
     * @param obj A partially populated Transport. <code>obj</code> will not be changed, this method returns a new object instead.
     * @return a Transport object containing all values available in the database.
     * @throws TorqueException
     */	 
	public static Transport doSelectSingle(Transport obj) throws TorqueException
	{			
		Transport tmpObj = getObjectFromCache(obj);
		
		if(tmpObj == null)
		{
			List objList = net.sf.iquiver.om.BaseTransportPeer.doSelect(obj);
			if(objList != null && !objList.isEmpty())
			{
				tmpObj = (Transport)objList.get(0);
				if(tmpObj != null)
				{
					addObjectToCache(tmpObj.getPrimaryKey(), tmpObj);
				}
			}
		}
		
		return tmpObj;
	}

    /**
	 * Fetches a list of Transports by a partially populated Transport object from the database.<br>
	 * If the result list is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched list of objects to the cache	 
     * @param obj A partially populated Transport. <code>obj</code> will not be changed, this method returns a new object instead.
     * @return a Transport object containing all values available in the database.
     * @throws TorqueException
     */	 
	public static List doSelect(Transport obj) throws TorqueException
	{			
		return doSelect(buildCriteria(obj));
	}
		
    /**
     * Fetches a list of Transports from the database by a given criteria<br>
	 * If the CriteriaResultListCache is enabled and the list of objects id already stored<br>
	 * in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache	 
     * @param crit
     * @return a list of Transports fetched from the database or cache
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
     * Fetches a list of Transports from the database by a given criteria<br>
	 * If the CriteriaResultListCache is enabled and the list of objects id already stored<br>
	 * in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache<br>
     * This method uses a existing Transaction               
     * @param crit
     * @return a list of Transports fetched from the database or cache
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
			results = net.sf.iquiver.om.BaseTransportPeer.doSelect(crit, con);
		
	        if(results != null && isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
	        {
		        //adding all retrieved objects to cache
				addCriteriaResultListToCache(crit, results);
			}
		}
		
		return results;
	}		
	
    /**
     * Fetches all Transports from the database<br>
	 * If the objects are already stored in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache	 
     * @param crit
     * @return a list of Transports fetched from the database or cache
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
     * Fetches all Transports from the database<br>
	 * If the objects are already stored in the object cache, a list of cached objects will be returned<br>
     * As the case may be this method will add the fetched objects to the cache	 
     * @param crit
     * @return a list of Transports fetched from the database or cache
     * @throws TorqueException
     */	
	public static List doSelectAll(Connection con) throws TorqueException
	{
		return doSelect(clear_crit, con);
	}			


    
        /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws TorqueException Primary key was not found in database.
     */
    public static Transport retrieveByPK(int pk) throws TorqueException
    {
        return retrieveByPK(SimpleKey.keyFor(pk));
    }
  
    /**
     * Fetches a Transport from the database by a given primary key<br>
	 * If the Transport is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched object to the cache	 
     * @param key The primary key of the desired Transport
     * @return a Transport fetched from the database or cache
     * @throws TorqueException
     */	
	public static Transport retrieveByPK(ObjectKey key) throws TorqueException
	{
		Transport obj = getObjectFromCache(key);
		
		if(obj == null)
		{
			obj = net.sf.iquiver.om.BaseTransportPeer.retrieveByPK(key);
			addObjectToCache(key, obj);
		}
		
		return obj;	
	}

    /**
     * Fetches a Transport from the database by a given primary key<br>
	 * If the Transport is already stored in the object cache, the cached object will be returned<br>
     * As the case may be this method will add the fetched object to the cache	 
     * This method uses a existing Transaction          
     * @param key The primary key of the desired Transport
     * @param con An existing connection
     * @return a Transport fetched from the database or cache
     * @throws TorqueException
     */	
	public static Transport retrieveByPK(ObjectKey key, Connection con) throws TorqueException
	{
		Transport obj = getObjectFromCache(key);
		
		if(obj == null)
		{
			obj = net.sf.iquiver.om.BaseTransportPeer.retrieveByPK(key, con);
			addObjectToCache(key, obj);
		}
		
		return obj;	
	}
	
    /**
     * Fetches multiple Transports from the database by a given list of primary keys<br>
	 * If the list of primary keys is already stored in the CriteriaResultListCache, the cached objects will be returned<br>
     * As the case may be this method will add the fetched list objects to the cache	 
     * @param pks The list of primary keys
     * @return a list of Transports fetched from the database or cache
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
     * Fetches multiple Transports from the database by a given list of primary keys<br>
	 * If the list of primary keys is already stored in the CriteriaResultListCache, the cached objects will be returned<br>
     * As the case may be this method will add the fetched list objects to the cache	 
     * This method uses a existing Transaction          
     * @param pks The list of primary keys
     * @param dbcon An existing connection     
     * @return a list of Transports fetched from the database or cache
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
              criteria.addIn( TRANSPORT_ID, pks );
          objs = doSelect(criteria, dbcon);
        }
        
        return objs;
    }



    /**
     * Deletes an Transport in the database, if the Transport is already stored in the object cache,<br>
     * it will be removed
     * @param obj
     * @throws TorqueException
     */
	public static void doDelete(Transport obj) throws TorqueException
	{		
		net.sf.iquiver.om.BaseTransportPeer.doDelete(obj);
		removeObjectFromCache(obj.getPrimaryKey());		
	}

    /**
     * Deletes an Transport in the database, if the Transport is already stored in the object cache,<br>
     * it will be removed<br>
     * This method uses a existing Transaction
     * @param obj
     * @throws TorqueException
     */
	public static void doDelete(Transport obj, Connection con) throws TorqueException
	{
		net.sf.iquiver.om.BaseTransportPeer.doDelete(obj, con);
		removeObjectFromCache(obj.getPrimaryKey());		
	}
	
    /**
     * Deletes one or more Transports in the database.<br>
     * If the CriteriaResultListCache is enabled and does contain an list of primary keys for the given criteria, the idList<br>
     * will get removed from the CriteriaResultListCache and also the corresponding Transports will be removed<br>
     * from the main object cache
     * @param crit
     * @throws TorqueException
     */
	public static void doDelete(final Criteria crit) throws TorqueException
	{
		net.sf.iquiver.om.BaseTransportPeer.doDelete(crit);

		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{		
			removeCriteriaResultListFromCache(crit);
		}				
	}		

    /**
     * Deletes one or more Transports in the database.
     * If the CriteriaResultListCache is enabled and does contain an list of primary keys for the given criteria, the idList<br>
     * will get removed from the CriteriaResultListCache and also the corresponding Transports will be removed<br>
     * from the main object cache<br>
     * This method uses a existing Transaction     
     * @param crit
     * @throws TorqueException
     */
	public static void doDelete(final Criteria crit, Connection con) throws TorqueException
	{
		net.sf.iquiver.om.BaseTransportPeer.doDelete(crit, con);
		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{
			removeCriteriaResultListFromCache(crit);
		}
	}

    /**
     * Deletes an Transport in the database by a given primary key<br>
     * If the Transport is already stored in the object cache, it will be removed
     * @param key
     * @throws TorqueException
     */	
	public static void doDelete(ObjectKey key) throws TorqueException
	{
		net.sf.iquiver.om.BaseTransportPeer.doDelete(key);		
		removeObjectFromCache(key);				
	}		

    /**
     * Deletes an Transport in the database by a given primary key<br>
     * If the Transport is already stored in the object cache, it will be removed<br>
     * This method uses a existing Transaction          
     * @param key
     * @throws TorqueException
     */	
	public static void doDelete(ObjectKey key, Connection con) throws TorqueException
	{
		net.sf.iquiver.om.BaseTransportPeer.doDelete(key, con);			
		removeObjectFromCache(key);
	}		
	
	    /**
     * Deletes an Transport in the database by a given primary key<br>
     * If the Transport is already stored in the object cache, it will be removed
		 * @param transportid
		     * @throws TorqueException
     */		    
	    public static void doDelete(
   			int transportid		    ) throws TorqueException
    {
		Criteria crit = new Criteria();
				
	   				crit.add(TRANSPORT_ID, transportid);
				doDelete(crit);
		
		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{		
							SimpleKey oKey = SimpleKey.keyFor(transportid);
						
			removeObjectFromCache(oKey);
		}		
    }    

	    /**
     * Deletes an Transport in the database by a given primary key<br>
     * If the Transport is already stored in the object cache, it will be removed<br>
     * This method uses a existing Transaction               
		 * @param transportid
		     * @throws TorqueException
     */		    
	    public static void doDelete(
   			int transportid				, Connection con) throws TorqueException
	{
		Criteria crit = new Criteria();
	   				crit.add(TRANSPORT_ID, transportid);
				net.sf.iquiver.om.BaseTransportPeer.doDelete(crit, con);
		
		if(isCacheEnabled() && isCacheForCriteriaSelectsEnabled())
		{		
							SimpleKey oKey = SimpleKey.keyFor(transportid);
						
			removeObjectFromCache(oKey);
		}				
    }    
    /**
     * Inserts or updates an Transport obj in the database<br>
     * As the case may be this method will add the fetched object to the cache (insert)<br>
     * or updates the object in the cache (update)
     * @param obj
     * @throws TorqueException
     */
	public static void doInsert(Transport obj) throws TorqueException
	{		
		removeObjectFromCache(obj.getPrimaryKey());
		net.sf.iquiver.om.BaseTransportPeer.doInsert(obj);
		if(obj != null)
		{
			addObjectToCache(obj.getPrimaryKey(), obj);		
		}
	}	

    /**
     * Inserts or updates an Transport obj in the database<br>
     * As the case may be this method will add the fetched object to the cache (insert)<br>
     * or updates the object in the cache (update)<br>
     * This method uses a existing Transaction                    
     * @param obj
     * @throws TorqueException
     */
	public static void doInsert(Transport obj, Connection con) throws TorqueException
	{
		removeObjectFromCache(obj.getPrimaryKey());
		net.sf.iquiver.om.BaseTransportPeer.doInsert(obj, con);
		if(obj != null)
		{
			addObjectToCache(obj.getPrimaryKey(), obj);		
		}
	}		
}
