package fr.iut2.sil4.data;

import java.io.Serializable;
import java.sql.Connection;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import org.apache.torque.TorqueException;
import org.apache.torque.map.TableMap;
import org.apache.torque.om.ComboKey;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.BooleanKey;
import org.apache.torque.om.Persistent;
import org.apache.torque.om.ColumnAccessByName;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.util.Transaction;
import org.apache.commons.lang.ObjectUtils;


/**
 * Table des matieres suivi par une classe
 *
 * This class was autogenerated by Torque on:
 *
 * [Mon Jan 20 16:44:52 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to MatiereClasse
 */
public abstract class BaseMatiereClasse 
    implements Persistent, Serializable, ColumnAccessByName
{
    /** Serial version */
    private static final long serialVersionUID = 1390232692303L;



    /** ID matiere classe */
    private int matiereClasseId = 0;

    /** ID classe */
    private int classeId = 0;

    /** ID matiere */
    private int matiereId = 0;

    /** Whether this object was modified after loading or after last save. */
    private boolean modified = true;

    /** 
     * Whether this object was loaded from the database or already saved 
     * (false) or whether it is not yet in the database(true).
     */
    private boolean isNew = true;

    /** Flag which indicates whether this object is currently saving. */
    private boolean saving = false;

    /** 
     * Flag which indicates whether this object is currently loaded
     * from the database. 
     */
    private boolean loading = false;

    /** 
     * Flag which indicates whether this object was deleted from the database.
     * Note that this flags does not always display the current database state,
     * there is no magical connection between this flag and the database.
     */
    private boolean deleted = false;

    /** Defines the aMatiere field. */
    private Matiere aMatiere = null;

    /** Defines the aClasse field. */
    private Classe aClasse = null;





    /**
     * Get the value of matiereClasseId.
     * The field is described as follows: 
     * ID matiere classe
     *
     * @return int
     */
    public int getMatiereClasseId() 
    {
        
        return matiereClasseId;
    }

    /**
     * Set the value of matiereClasseId.
     * The field is described as follows: 
     * ID matiere classe
     *
     * @param v new value
     */
    public void setMatiereClasseId(int v)
    {
        if (this.matiereClasseId != v)
        {
            setModified(true);
        }

        this.matiereClasseId = v;


    }
    
    /**
     * Get the value of classeId.
     * The field is described as follows: 
     * ID classe
     *
     * @return int
     */
    public int getClasseId() 
    {
        
        return classeId;
    }

    /**
     * Set the value of classeId.
     * The field is described as follows: 
     * ID classe
     *
     * @param v new value
     */
    public void setClasseId(int v)
    {
        if (this.classeId != v)
        {
            setModified(true);
        }

        this.classeId = v;
        if (aClasse != null && aClasse.getClasseId() != v)
        {
            aClasse = null;
        }


    }
    
    /**
     * Get the value of matiereId.
     * The field is described as follows: 
     * ID matiere
     *
     * @return int
     */
    public int getMatiereId() 
    {
        
        return matiereId;
    }

    /**
     * Set the value of matiereId.
     * The field is described as follows: 
     * ID matiere
     *
     * @param v new value
     */
    public void setMatiereId(int v)
    {
        if (this.matiereId != v)
        {
            setModified(true);
        }

        this.matiereId = v;
        if (aMatiere != null && aMatiere.getMatiereId() != v)
        {
            aMatiere = null;
        }


    }
    

    /**
     * Returns whether the object has ever been saved.  This will
     * be false, if the object was retrieved from storage or was created
     * and then saved.
     *
     * @return true, if the object has never been persisted.
     */
    public boolean isNew()
    {
        return isNew;
    }

    /**
     * Sets whether the object has ever been saved.
     *
     * @param isNew true if the object has never been saved, false otherwise.
     */
    public void setNew(boolean isNew)
    {
        this.isNew = isNew;
    }

    /**
     * Returns whether the object has been modified.
     *
     * @return True if the object has been modified.
     */
    public boolean isModified()
    {
        return modified;
    }

    /**
     * Sets whether the object has been modified.
     *
     * @param modified true if the object has been modified, false otherwise.
     */
    public void setModified(boolean modified)
    {
        this.modified = modified;
    }

    /**
     * Sets the modified state for the object to be false.
     */
    public void resetModified()
    {
        modified = false;
    }


    /**
     * Returns whether this object is currently saving.
     *
     * @return true if this object is currently saving, false otherwise.
     */
    public boolean isSaving()
    {
        return saving;
    }

    /**
     * Sets whether this object is currently saving.
     *
     * @param saving true if this object is currently saving, false otherwise.
     */
    public void setSaving(boolean saving)
    {
        this.saving = saving;
    }


    /**
     * Returns whether this object is currently being loaded from the database.
     *
     * @return true if this object is currently loading, false otherwise.
     */
    public boolean isLoading()
    {
        return loading;
    }

    /**
     * Sets whether this object is currently being loaded from the database.
     *
     * @param loading true if this object is currently loading, false otherwise.
     */
    public void setLoading(boolean loading)
    {
        this.loading = loading;
    }


    /**
     * Returns whether this object was deleted from the database.
     * Note that this getter does not automatically reflect database state,
     * it will be set to true by Torque if doDelete() was called with this 
     * object. Bulk deletes and deletes via primary key do not change
     * this flag. Also, if doDelete() was called on an object which does
     * not exist in the database, the deleted flag is set to true even if
     * it was not deleted.
     *
     * @return true if this object was deleted, false otherwise.
     */
    public boolean isDeleted()
    {
        return deleted;
    }

    /**
     * Sets whether this object was deleted from the database.
     *
     * @param deleted true if this object was deleted, false otherwise.
     */
    public void setDeleted(boolean deleted)
    {
        this.deleted = deleted;
    }


    /**
     * Returns the associated Matiere object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Matiere object
     * @throws TorqueException when reading from the database fails.
     */
    public Matiere getMatiere()
        throws TorqueException
    {
        if (aMatiere == null && this.matiereId != 0)
        {
            aMatiere = fr.iut2.sil4.data.MatierePeer.retrieveByPK(SimpleKey.keyFor(this.matiereId));
        }
        return aMatiere;
    }

    /**
     * Return the associated Matiere object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Matiere object
     * @throws TorqueException
     */
    public Matiere getMatiere(Connection connection)
        throws TorqueException
    {
        if (aMatiere == null && this.matiereId != 0)
        {
            aMatiere = fr.iut2.sil4.data.MatierePeer.retrieveByPK(SimpleKey.keyFor(this.matiereId), connection);
        }
        return aMatiere;
    }


    /**
     * Declares an association between this object and a Matiere object
     *
     * @param v Matiere
     */
    public void setMatiere(Matiere v)
    {
        if (v == null)
        {
            setMatiereId(0);
        }
        else
        {
            setMatiereId(v.getMatiereId());
        }
        aMatiere = v;
    }
    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setMatiereKey(ObjectKey key) throws TorqueException
    {
       
        setMatiereId(((NumberKey) key).intValue());
     }

    /**
     * Returns the associated Classe object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Classe object
     * @throws TorqueException when reading from the database fails.
     */
    public Classe getClasse()
        throws TorqueException
    {
        if (aClasse == null && this.classeId != 0)
        {
            aClasse = fr.iut2.sil4.data.ClassePeer.retrieveByPK(SimpleKey.keyFor(this.classeId));
        }
        return aClasse;
    }

    /**
     * Return the associated Classe object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Classe object
     * @throws TorqueException
     */
    public Classe getClasse(Connection connection)
        throws TorqueException
    {
        if (aClasse == null && this.classeId != 0)
        {
            aClasse = fr.iut2.sil4.data.ClassePeer.retrieveByPK(SimpleKey.keyFor(this.classeId), connection);
        }
        return aClasse;
    }


    /**
     * Declares an association between this object and a Classe object
     *
     * @param v Classe
     */
    public void setClasse(Classe v)
    {
        if (v == null)
        {
            setClasseId(0);
        }
        else
        {
            setClasseId(v.getClasseId());
        }
        aClasse = v;
    }
    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setClasseKey(ObjectKey key) throws TorqueException
    {
       
        setClasseId(((NumberKey) key).intValue());
     }






    private static final List<String> FIELD_NAMES;

    static
    {
        List<String> fieldNames
                = new ArrayList<String>();
        fieldNames.add("MatiereClasseId");
        fieldNames.add("ClasseId");
        fieldNames.add("MatiereId");
        FIELD_NAMES = Collections.unmodifiableList(fieldNames);
    }

    /**
     * Generate a list of field names.
     *
     * @return a list of field names
     */
    public static List<String> getFieldNames()
    {
        return FIELD_NAMES;
    }

    /**
     * Retrieves a field from the object by field (Java) name passed in as a String.
     *
     * @param name field name
     * @return value
     */
    public Object getByName(String name)
    {
        if (name.equals("MatiereClasseId"))
        {
            return new Integer(getMatiereClasseId());
        }
        if (name.equals("ClasseId"))
        {
            return new Integer(getClasseId());
        }
        if (name.equals("MatiereId"))
        {
            return new Integer(getMatiereId());
        }
        return null;
    }

    /**
     * Set a field in the object by field (Java) name.
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (name.equals("MatiereClasseId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMatiereClasseId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("ClasseId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setClasseId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("MatiereId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setMatiereId(((Integer) value).intValue());
            return true;
        }
        return false;
    }

    /**
     * Retrieves a field from the object by name passed in
     * as a String.  The String must be one of the static
     * Strings defined in this Class' Peer.
     *
     * @param name peer name
     * @return value
     */
    public Object getByPeerName(String name)
    {
        if (name.equals(fr.iut2.sil4.data.MatiereClassePeer.MATIERE_CLASSE_ID))
        {
            return new Integer(getMatiereClasseId());
        }
        if (name.equals(fr.iut2.sil4.data.MatiereClassePeer.CLASSE_ID))
        {
            return new Integer(getClasseId());
        }
        if (name.equals(fr.iut2.sil4.data.MatiereClassePeer.MATIERE_ID))
        {
            return new Integer(getMatiereId());
        }
        return null;
    }

    /**
     * Set field values by Peer Field Name
     *
     * @param name field name
     * @param value field value
     * @return True if value was set, false if not (invalid name / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPeerName(String name, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (fr.iut2.sil4.data.MatiereClassePeer.MATIERE_CLASSE_ID.getSqlExpression().equals(name))
        {
            return setByName("MatiereClasseId", value);
        }
        if (fr.iut2.sil4.data.MatiereClassePeer.CLASSE_ID.getSqlExpression().equals(name))
        {
            return setByName("ClasseId", value);
        }
        if (fr.iut2.sil4.data.MatiereClassePeer.MATIERE_ID.getSqlExpression().equals(name))
        {
            return setByName("MatiereId", value);
        }
        return false;
    }

    /**
     * Retrieves a field from the object by Position as specified
     * in the xml schema.  Zero-based.
     *
     * @param pos position in xml schema
     * @return value
     */
    public Object getByPosition(int pos)
    {
        if (pos == 0)
        {
            return new Integer(getMatiereClasseId());
        }
        if (pos == 1)
        {
            return new Integer(getClasseId());
        }
        if (pos == 2)
        {
            return new Integer(getMatiereId());
        }
        return null;
    }

    /**
     * Set field values by its position (zero based) in the XML schema.
     *
     * @param position The field position
     * @param value field value
     * @return True if value was set, false if not (invalid position / protected field).
     * @throws IllegalArgumentException if object type of value does not match field object type.
     * @throws TorqueException If a problem occurs with the set[Field] method.
     */
    public boolean setByPosition(int position, Object value)
        throws TorqueException, IllegalArgumentException
    {
        if (position == 0)
        {
            return setByName("MatiereClasseId", value);
        }
        if (position == 1)
        {
            return setByName("ClasseId", value);
        }
        if (position == 2)
        {
            return setByName("MatiereId", value);
        }
        return false;
    }



    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.
     *
     * @param toSave the object to be saved, not null.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save() throws TorqueException
    {
        save(MatiereClassePeer.DATABASE_NAME);
    }

    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.
     *
     * @param toSave the object to be saved, not null.
     * @param dbName the name of the database to which the object
     *        should be saved.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save(String dbName) 
            throws TorqueException
    {
        Connection con = null;
        try
        {
            con = Transaction.begin(dbName);
            save(con);
            Transaction.commit(con);
        }
        catch(TorqueException e)
        {
            Transaction.safeRollback(con);
            throw e;
        }
    }

    /**
     * Stores an object in the database.  If the object is new,
     * it is inserted; otherwise an update is performed.  This method
     * is meant to be used as part of a transaction, otherwise use
     * the save() method and the connection details will be handled
     * internally.
     *
     * @param toSave the object to be saved, not null.
     * @param con the connection to use for saving the object, not null.
     *
     * @throws TorqueException if an error occurs during saving.
     */
    public void save(Connection con) 
            throws TorqueException
    {
        if (isSaving())
        {
            return;
        }
        try
        {
            setSaving(true);
            // If this object has been modified, then save it to the database.
            if (isModified())
            {
                if (isNew())
                {
                    MatiereClassePeer.doInsert((MatiereClasse) this, con);
                    setNew(false);
                }
                else
                {
                    MatiereClassePeer.doUpdate((MatiereClasse) this, con);
                }
            }

        }
        finally
        {
            setSaving(false);
        }
    }




    /**
     * Set the PrimaryKey using ObjectKey.
     *
     * @param key matiereClasseId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setMatiereClasseId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setMatiereClasseId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getMatiereClasseId());
    }


    /**
     * Returns an id that differentiates the referenced Matiere object
     * from all other Matiere objects.
     *
     * @return an ObjectKey.
     */
    public ObjectKey getForeignKeyForMatiere()
    {
        int foreignKey = getMatiereId();
        if (foreignKey == 0)
        {
            return SimpleKey.keyFor((Number) null);
        }
        return SimpleKey.keyFor(foreignKey);
    }
    /**
     * Returns an id that differentiates the referenced Classe object
     * from all other Classe objects.
     *
     * @return an ObjectKey.
     */
    public ObjectKey getForeignKeyForClasse()
    {
        int foreignKey = getClasseId();
        if (foreignKey == 0)
        {
            return SimpleKey.keyFor((Number) null);
        }
        return SimpleKey.keyFor(foreignKey);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public MatiereClasse copy() throws TorqueException
    {
        return copy(true);
    }

    /**
     * Makes a copy of this object using a connection.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     *
     * @param con the database connection to read associated objects.
     */
    public MatiereClasse copy(Connection con) throws TorqueException
    {
        return copy(true, con);
    }

    /**
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     */
    public MatiereClasse copy(boolean deepcopy) throws TorqueException
    {
        MatiereClasse matiereClasse = new MatiereClasse();

        return copyInto(matiereClasse, deepcopy);
    }

    /**
     * Makes a copy of this object using connection.
     * It creates a new object filling in the simple attributes.
     * If the parameter deepcopy is true, it then fills all the
     * association collections and sets the related objects to
     * isNew=true.
     *
     * @param deepcopy whether to copy the associated objects.
     * @param con the database connection to read associated objects.
     */
    public MatiereClasse copy(boolean deepcopy, Connection con) throws TorqueException
    {
        MatiereClasse matiereClasse = new MatiereClasse();

        return copyInto(matiereClasse, deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    public MatiereClasse copyInto(MatiereClasse copyObj) throws TorqueException
    {
        return copyInto(copyObj, true);
    }

    /**
     * Fills the copyObj with the contents of this object using connection.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param con the database connection to read associated objects.
     */
    public MatiereClasse copyInto(MatiereClasse copyObj, Connection con) throws TorqueException
    {
        return copyInto(copyObj, true, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     */
    protected MatiereClasse copyInto(MatiereClasse copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setMatiereClasseId(0);
        copyObj.setClasseId(classeId);
        copyObj.setMatiereId(matiereId);

        if (deepcopy)
        {
        }
        return copyObj;
    }
        
    
    /**
     * Fills the copyObj with the contents of this object using connection.
     * If deepcopy is true, The associated objects are also copied
     * and treated as new objects.
     *
     * @param copyObj the object to fill.
     * @param deepcopy whether the associated objects should be copied.
     * @param con the database connection to read associated objects.
     */
    public MatiereClasse copyInto(MatiereClasse copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setMatiereClasseId(0);
        copyObj.setClasseId(classeId);
        copyObj.setMatiereId(matiereId);

        if (deepcopy)
        {
        }
        return copyObj;
    }

    /** The Peer class */
    private static final fr.iut2.sil4.data.MatiereClassePeer peer
            = new fr.iut2.sil4.data.MatiereClassePeer();

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public fr.iut2.sil4.data.MatiereClassePeer getPeer()
    {
        return peer;
    }

    /**
     * Retrieves the TableMap object related to this Table data without
     * compiler warnings of using getPeer().getTableMap().
     *
     * @return The associated TableMap object.
     */
    public TableMap getTableMap() throws TorqueException
    {
        return fr.iut2.sil4.data.MatiereClassePeer.getTableMap();
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("MatiereClasse:\n");
        str.append("matiereClasseId = ")
           .append(getMatiereClasseId())
           .append("\n");
        str.append("classeId = ")
           .append(getClasseId())
           .append("\n");
        str.append("matiereId = ")
           .append(getMatiereId())
           .append("\n");
        return(str.toString());
    }

    /**
     * Compares the primary key of this instance with the key of another.
     *
     * @param toCompare The object to compare to.
     * @return Whether the primary keys are equal and the object have the
     *         same class.
     */
    public boolean equals(Object toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (!getClass().equals(toCompare.getClass()))
        {
            return false;
        }
        MatiereClasse other = (MatiereClasse) toCompare;
        if (getPrimaryKey() == null || other.getPrimaryKey() == null)
        {
            return false;
        }
        return getPrimaryKey().equals(other.getPrimaryKey());
    }

    /**
     * If the primary key is not <code>null</code>, return the hashcode of the
     * primary key.  Otherwise calls <code>Object.hashCode()</code>.
     *
     * @return an <code>int</code> value
     */
    public int hashCode()
    {
        ObjectKey ok = getPrimaryKey();
        if (ok == null)
        {
            return super.hashCode();
        }

        return ok.hashCode();
    }



    /**
     * Compares the content of this object to another object
     *
     * @param toCompare The object to compare to.
     * @return true if all of the columns in the other object have 
     *         the same value as the objects in this class.
     */
    public boolean valueEquals(MatiereClasse toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (this.matiereClasseId != toCompare.getMatiereClasseId())
        {
            return false;
        }
        if (this.classeId != toCompare.getClasseId())
        {
            return false;
        }
        if (this.matiereId != toCompare.getMatiereId())
        {
            return false;
        }
        return true;
    }



}