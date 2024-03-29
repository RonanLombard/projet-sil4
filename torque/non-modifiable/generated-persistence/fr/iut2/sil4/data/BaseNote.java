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
 * Table des notes
 *
 * This class was autogenerated by Torque on:
 *
 * [Mon Jan 20 16:44:52 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to Note
 */
public abstract class BaseNote 
    implements Persistent, Serializable, ColumnAccessByName
{
    /** Serial version */
    private static final long serialVersionUID = 1390232692392L;



    /** ID note */
    private int noteId = 0;

    /** ID etudiant */
    private int etudiantId = 0;

    /** ID matiere */
    private int matiereId = 0;

    /** Valeur de la note */
    private int valeur = 0;

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

    /** Defines the aEtudiant field. */
    private Etudiant aEtudiant = null;

    /** Defines the aMatiere field. */
    private Matiere aMatiere = null;





    /**
     * Get the value of noteId.
     * The field is described as follows: 
     * ID note
     *
     * @return int
     */
    public int getNoteId() 
    {
        
        return noteId;
    }

    /**
     * Set the value of noteId.
     * The field is described as follows: 
     * ID note
     *
     * @param v new value
     */
    public void setNoteId(int v)
    {
        if (this.noteId != v)
        {
            setModified(true);
        }

        this.noteId = v;


    }
    
    /**
     * Get the value of etudiantId.
     * The field is described as follows: 
     * ID etudiant
     *
     * @return int
     */
    public int getEtudiantId() 
    {
        
        return etudiantId;
    }

    /**
     * Set the value of etudiantId.
     * The field is described as follows: 
     * ID etudiant
     *
     * @param v new value
     */
    public void setEtudiantId(int v)
    {
        if (this.etudiantId != v)
        {
            setModified(true);
        }

        this.etudiantId = v;
        if (aEtudiant != null && aEtudiant.getEtudiantId() != v)
        {
            aEtudiant = null;
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
     * Get the value of valeur.
     * The field is described as follows: 
     * Valeur de la note
     *
     * @return int
     */
    public int getValeur() 
    {
        
        return valeur;
    }

    /**
     * Set the value of valeur.
     * The field is described as follows: 
     * Valeur de la note
     *
     * @param v new value
     */
    public void setValeur(int v)
    {
        if (this.valeur != v)
        {
            setModified(true);
        }

        this.valeur = v;


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
     * Returns the associated Etudiant object.
     * If it was not retrieved before, the object is retrieved from
     * the database
     *
     * @return the associated Etudiant object
     * @throws TorqueException when reading from the database fails.
     */
    public Etudiant getEtudiant()
        throws TorqueException
    {
        if (aEtudiant == null && this.etudiantId != 0)
        {
            aEtudiant = fr.iut2.sil4.data.EtudiantPeer.retrieveByPK(SimpleKey.keyFor(this.etudiantId));
        }
        return aEtudiant;
    }

    /**
     * Return the associated Etudiant object
     * If it was not retrieved before, the object is retrieved from
     * the database using the passed connection
     *
     * @param connection the connection used to retrieve the associated object
     *        from the database, if it was not retrieved before
     * @return the associated Etudiant object
     * @throws TorqueException
     */
    public Etudiant getEtudiant(Connection connection)
        throws TorqueException
    {
        if (aEtudiant == null && this.etudiantId != 0)
        {
            aEtudiant = fr.iut2.sil4.data.EtudiantPeer.retrieveByPK(SimpleKey.keyFor(this.etudiantId), connection);
        }
        return aEtudiant;
    }


    /**
     * Declares an association between this object and a Etudiant object
     *
     * @param v Etudiant
     */
    public void setEtudiant(Etudiant v)
    {
        if (v == null)
        {
            setEtudiantId(0);
        }
        else
        {
            setEtudiantId(v.getEtudiantId());
        }
        aEtudiant = v;
    }
    /**
     * Provides convenient way to set a relationship based on a
     * ObjectKey, for example
     * <code>bar.setFooKey(foo.getPrimaryKey())</code>
     *
     */
    public void setEtudiantKey(ObjectKey key) throws TorqueException
    {
       
        setEtudiantId(((NumberKey) key).intValue());
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






    private static final List<String> FIELD_NAMES;

    static
    {
        List<String> fieldNames
                = new ArrayList<String>();
        fieldNames.add("NoteId");
        fieldNames.add("EtudiantId");
        fieldNames.add("MatiereId");
        fieldNames.add("Valeur");
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
        if (name.equals("NoteId"))
        {
            return new Integer(getNoteId());
        }
        if (name.equals("EtudiantId"))
        {
            return new Integer(getEtudiantId());
        }
        if (name.equals("MatiereId"))
        {
            return new Integer(getMatiereId());
        }
        if (name.equals("Valeur"))
        {
            return new Integer(getValeur());
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
        if (name.equals("NoteId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setNoteId(((Integer) value).intValue());
            return true;
        }
        if (name.equals("EtudiantId"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setEtudiantId(((Integer) value).intValue());
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
        if (name.equals("Valeur"))
        {
            if (value == null || ! (Integer.class.isInstance(value)))
            {
                throw new IllegalArgumentException("setByName: value parameter was null or not an Integer object.");
            }
            setValeur(((Integer) value).intValue());
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
        if (name.equals(fr.iut2.sil4.data.NotePeer.NOTE_ID))
        {
            return new Integer(getNoteId());
        }
        if (name.equals(fr.iut2.sil4.data.NotePeer.ETUDIANT_ID))
        {
            return new Integer(getEtudiantId());
        }
        if (name.equals(fr.iut2.sil4.data.NotePeer.MATIERE_ID))
        {
            return new Integer(getMatiereId());
        }
        if (name.equals(fr.iut2.sil4.data.NotePeer.VALEUR))
        {
            return new Integer(getValeur());
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
        if (fr.iut2.sil4.data.NotePeer.NOTE_ID.getSqlExpression().equals(name))
        {
            return setByName("NoteId", value);
        }
        if (fr.iut2.sil4.data.NotePeer.ETUDIANT_ID.getSqlExpression().equals(name))
        {
            return setByName("EtudiantId", value);
        }
        if (fr.iut2.sil4.data.NotePeer.MATIERE_ID.getSqlExpression().equals(name))
        {
            return setByName("MatiereId", value);
        }
        if (fr.iut2.sil4.data.NotePeer.VALEUR.getSqlExpression().equals(name))
        {
            return setByName("Valeur", value);
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
            return new Integer(getNoteId());
        }
        if (pos == 1)
        {
            return new Integer(getEtudiantId());
        }
        if (pos == 2)
        {
            return new Integer(getMatiereId());
        }
        if (pos == 3)
        {
            return new Integer(getValeur());
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
            return setByName("NoteId", value);
        }
        if (position == 1)
        {
            return setByName("EtudiantId", value);
        }
        if (position == 2)
        {
            return setByName("MatiereId", value);
        }
        if (position == 3)
        {
            return setByName("Valeur", value);
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
        save(NotePeer.DATABASE_NAME);
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
                    NotePeer.doInsert((Note) this, con);
                    setNew(false);
                }
                else
                {
                    NotePeer.doUpdate((Note) this, con);
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
     * @param key noteId ObjectKey
     */
    public void setPrimaryKey(ObjectKey key)
        
    {
        setNoteId(((NumberKey) key).intValue());
    }

    /**
     * Set the PrimaryKey using a String.
     *
     * @param key
     */
    public void setPrimaryKey(String key) 
    {
        setNoteId(Integer.parseInt(key));
    }


    /**
     * returns an id that differentiates this object from others
     * of its class.
     */
    public ObjectKey getPrimaryKey()
    {
        return SimpleKey.keyFor(getNoteId());
    }


    /**
     * Returns an id that differentiates the referenced Etudiant object
     * from all other Etudiant objects.
     *
     * @return an ObjectKey.
     */
    public ObjectKey getForeignKeyForEtudiant()
    {
        int foreignKey = getEtudiantId();
        if (foreignKey == 0)
        {
            return SimpleKey.keyFor((Number) null);
        }
        return SimpleKey.keyFor(foreignKey);
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
     * Makes a copy of this object.
     * It creates a new object filling in the simple attributes.
     * It then fills all the association collections and sets the
     * related objects to isNew=true.
     */
    public Note copy() throws TorqueException
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
    public Note copy(Connection con) throws TorqueException
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
    public Note copy(boolean deepcopy) throws TorqueException
    {
        Note note = new Note();

        return copyInto(note, deepcopy);
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
    public Note copy(boolean deepcopy, Connection con) throws TorqueException
    {
        Note note = new Note();

        return copyInto(note, deepcopy, con);
    }
  
    /**
     * Fills the copyObj with the contents of this object.
     * The associated objects are also copied and treated as new objects.
     *
     * @param copyObj the object to fill.
     */
    public Note copyInto(Note copyObj) throws TorqueException
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
    public Note copyInto(Note copyObj, Connection con) throws TorqueException
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
    protected Note copyInto(Note copyObj, boolean deepcopy) throws TorqueException
    {
        copyObj.setNoteId(0);
        copyObj.setEtudiantId(etudiantId);
        copyObj.setMatiereId(matiereId);
        copyObj.setValeur(valeur);

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
    public Note copyInto(Note copyObj, boolean deepcopy, Connection con) throws TorqueException
    {
        copyObj.setNoteId(0);
        copyObj.setEtudiantId(etudiantId);
        copyObj.setMatiereId(matiereId);
        copyObj.setValeur(valeur);

        if (deepcopy)
        {
        }
        return copyObj;
    }

    /** The Peer class */
    private static final fr.iut2.sil4.data.NotePeer peer
            = new fr.iut2.sil4.data.NotePeer();

    /**
     * returns a peer instance associated with this om.  Since Peer classes
     * are not to have any instance attributes, this method returns the
     * same instance for all member of this class. The method could therefore
     * be static, but this would prevent one from overriding the behavior.
     */
    public fr.iut2.sil4.data.NotePeer getPeer()
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
        return fr.iut2.sil4.data.NotePeer.getTableMap();
    }



    public String toString()
    {
        StringBuffer str = new StringBuffer();
        str.append("Note:\n");
        str.append("noteId = ")
           .append(getNoteId())
           .append("\n");
        str.append("etudiantId = ")
           .append(getEtudiantId())
           .append("\n");
        str.append("matiereId = ")
           .append(getMatiereId())
           .append("\n");
        str.append("valeur = ")
           .append(getValeur())
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
        Note other = (Note) toCompare;
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
    public boolean valueEquals(Note toCompare)
    {
        if (toCompare == null)
        {
            return false;
        }
        if (this == toCompare)
        {
            return true;
        }
        if (this.noteId != toCompare.getNoteId())
        {
            return false;
        }
        if (this.etudiantId != toCompare.getEtudiantId())
        {
            return false;
        }
        if (this.matiereId != toCompare.getMatiereId())
        {
            return false;
        }
        if (this.valeur != toCompare.getValeur())
        {
            return false;
        }
        return true;
    }



}
