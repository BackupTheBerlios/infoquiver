/*
 * StageListener.java
 * 
 * Created on 19.09.2003
 */
package net.sf.iquiver.admin.widgets;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

/**
 * @author netseeker aka Michael Manske
 */
public abstract class ValidationListener implements PropertyChangeListener
{
    public static String VALIDATION_RESULT = "validation_result";

    /* (non-Javadoc)
     * @see java.beans.PropertyChangeListener#propertyChange(java.beans.PropertyChangeEvent)
     */
    public void propertyChange(PropertyChangeEvent evt)
    {
        boolean isvalid;

        if ( evt.getPropertyName().equals(VALIDATION_RESULT) && (evt.getOldValue().equals(evt.getNewValue()) == false) )
        {
            isvalid = Boolean.valueOf(evt.getNewValue().toString()).booleanValue();
            validationPerformed(evt.getSource(), isvalid);
        }
    }

    public abstract void validationPerformed(Object source, boolean isvalid);
}
