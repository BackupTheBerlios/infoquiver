/*
 * SimpleCriteria.java Created on 02.03.2004
 */
package net.sf.iquiver.util.om;

import org.apache.torque.util.Criteria;

/**
 * @author netseeker aka Michael Manske 
 */
public class SimpleCriteria extends Criteria
{
    /** currently used as DEFAULT_CAPACITY in Criteria is private */
    private static final int DEFAULT_CAPACITY = 10;

    /*
     * Constructor
     */
    public SimpleCriteria()
    {
        super( DEFAULT_CAPACITY );
    }

    /*
     * Represents the Greater Than in the WHERE clause of an SQL Statement
     * 
     * @param columnname the column name @param columnvalue the column value to
     * be compared against
     */
    public SimpleCriteria addGreaterThan( String columnname, int columnvalue )
    {
        super.add( columnname, columnvalue, Criteria.GREATER_THAN);
        return this;
    }

    /*
     * Represents the Is NULL in the WHERE clause of an SQL Statement
     * 
     * @param columnname the column name
     */
    public SimpleCriteria addIsNull( String columnname )
    {
        String str = columnname + " is NULL";
        super.add( columnname, (Object) str, Criteria.CUSTOM);
        return this;
    }

    public SimpleCriteria addLike( String columnname )
    {
        String str = columnname + " is NULL";
        super.add( columnname, (Object) "LIKE", Criteria.CUSTOM);
        return this;
    }

    /*
     * Represents the Is not NULL in the WHERE clause of an SQL Statement
     * 
     * @param columnname the column name
     */
    public SimpleCriteria addIsNotNull( String columnname )
    {
        String str = columnname + " is not NULL";
        super.add( columnname, (Object) str, Criteria.CUSTOM);
        return this;
    }

    /*
     * Represents the Is NULL in the WHERE clause of an SQL Statement
     * 
     * @param columnname the column name
     */
    public SimpleCriteria addIsBetween( String columnname, int min, int max )
    {
        super.add( columnname, min, Criteria.GREATER_THAN);
        Criteria.Criterion criterion = super.getCriterion( columnname);
        criterion.and( super.getNewCriterion( criterion.getTable(), criterion.getColumn(), new Integer( max ),
                Criteria.LESS_EQUAL));
        return this;
    }

    /*
     * Represents the Is NULL in the WHERE clause of an SQL Statement
     * 
     * @param columnname the column name
     */
    public SimpleCriteria addIsBetween( String columnname, long min, long max )
    {
        super.add( columnname, min, Criteria.GREATER_THAN);
        Criteria.Criterion criterion = super.getCriterion( columnname);
        criterion.and( super.getNewCriterion( criterion.getTable(), criterion.getColumn(), new Long( max ),
                Criteria.LESS_EQUAL));
        return this;
    }
    
}
