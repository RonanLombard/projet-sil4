package fr.iut2.sil4.data;

import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Types;
import java.io.IOException;
import java.io.InputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Reader;
import java.io.StringReader;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;
import java.util.HashSet;

import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.torque.NoRowsException;
import org.apache.torque.OptimisticLockingFailedException;
import org.apache.torque.TooManyRowsException;
import org.apache.torque.Torque;
import org.apache.torque.TorqueException;
import org.apache.torque.TorqueRuntimeException;
import org.apache.torque.criteria.Criteria;
import org.apache.torque.criteria.Criterion;
import org.apache.torque.om.mapper.RecordMapper;
import org.apache.torque.om.mapper.CompositeMapper;
import org.apache.torque.om.DateKey;
import org.apache.torque.om.NumberKey;
import org.apache.torque.om.StringKey;
import org.apache.torque.om.ObjectKey;
import org.apache.torque.om.SimpleKey;
import org.apache.torque.om.ComboKey;
import org.apache.torque.map.TableMap;
import org.apache.torque.util.Transaction;
import org.apache.torque.util.ColumnValues;
import org.apache.torque.util.JdbcTypedValue;



/**
 * Table des matieres
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Mon Jan 20 16:44:53 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to MatierePeer
 */

public abstract class BaseMatierePeerImpl
    extends org.apache.torque.util.BasePeerImpl<Matiere>
{
    /** The class log. */
    private static Log log = LogFactory.getLog(BaseMatierePeerImpl.class);

    /** Serial version */
    private static final long serialVersionUID = 1390232693116L;



    /**
     * Constructor.
     * The recordMapper, tableMap and databaseName fields are correctly
     * initialized.
     */
    public BaseMatierePeerImpl()
    {
        this(new MatiereRecordMapper(),
            MatierePeer.TABLE,
            MatierePeer.DATABASE_NAME);
    }

    /**
     * Constructor providing the objects to be injected as parameters.
     *
     * @param recordMapper a record mapper to map JDBC result sets to objects
     * @param tableMap the default table map
     * @param databaseName the name of the database
     */
    public BaseMatierePeerImpl(
            RecordMapper<Matiere> recordMapper, 
            TableMap tableMap,
            String databaseName)
    {
        super(recordMapper, tableMap, databaseName);
    }


    /**
     * Selects Matiere objects from the database which have
     * the same content as the passed object.
     *
     * @return The list of selected objects, not null.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Matiere> doSelect(Matiere obj)
            throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Selects at most one Matiere object from the database
     * which has the same content as the passed object.
     *
     * @return the selected Object, or null if no object was selected.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public Matiere doSelectSingleRecord(
                Matiere obj)
            throws TorqueException
    {
        List<Matiere> matiereList = doSelect(obj);
        Matiere matiere = null;
        if (matiereList.size() > 1)
        {
            throw new TooManyRowsException("Object " + obj 
                + " matched more than one record");
        }
        if (!matiereList.isEmpty())
        {
            matiere = matiereList.get(0);
        }
        return matiere;
    }

    /**
     * Returns a new instance of the Data object class
     */
    public Matiere getDbObjectInstance()
    {
        return new Matiere();
    }


    /**
     * Method to do inserts.
     *
     * @param columnValues the values to insert.
     *
     * @return the primary key of the inserted row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public ObjectKey doInsert(ColumnValues columnValues) throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatierePeer.DATABASE_NAME);
            ObjectKey result = doInsert(columnValues, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Criteria) method.
     *
     * @param columnValues the values to insert.
     * @param con the connection to use, not null.
     *
     * @return the primary key of the inserted row.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public ObjectKey doInsert(ColumnValues columnValues, Connection con)
        throws TorqueException
    {
        correctBooleans(columnValues);
        return super.doInsert(columnValues, con);
    }

    /**
     * Method to do inserts
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public void doInsert(Matiere obj) throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildColumnValues(obj)));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(Matiere) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public void doInsert(Matiere obj, Connection con)
        throws TorqueException
    {
        ObjectKey primaryKey = doInsert(buildColumnValues(obj), con);
        if (primaryKey != null)
        {
            obj.setPrimaryKey(primaryKey);
        }
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do updates.
     *
     * @param columnValues the values to update plus the primary key
     *        identifying the row to update.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(ColumnValues columnValues) throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatierePeer.DATABASE_NAME);
            int result = doUpdate(columnValues, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Method to do updates.  This method is to be used during a transaction,
     * otherwise use the doUpdate(Criteria) method.
     *
     * @param columnValues the values to update plus the primary key
     *        identifying the row to update.
     * @param con the connection to use, not null.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(ColumnValues columnValues, Connection con)
        throws TorqueException
    {
        Criteria selectCriteria 
                = new Criteria(MatierePeer.DATABASE_NAME);
        correctBooleans(columnValues);

        selectCriteria.where(
                MatierePeer.MATIERE_ID,
                columnValues.remove(MatierePeer.MATIERE_ID).getValue());


        int rowCount = doUpdate(selectCriteria, columnValues, con);
        return rowCount;
    }

    /**
     * Updates an Matiere in the database.
     * The primary key is used to identify the object to update.
     *
     * @param obj the data object to update in the database.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(Matiere obj) throws TorqueException
    {
        ColumnValues columnValues = buildColumnValues(obj);
        int result = doUpdate(columnValues);
        obj.setModified(false);
        return result;
    }

    /**
     * Updates a Matiere in the database.
     * The primary key is used to identify the object to update.
     * This method is to be used during a transaction,
     * otherwise the doUpdate(Matiere) method can be used.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use, not null.
     
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(Matiere obj, Connection con)
        throws TorqueException
    {
        ColumnValues columnValues = buildColumnValues(obj);
        int result = doUpdate(columnValues, con);
        obj.setModified(false);
        return result;
    }

    /**
     * Deletes a data object, i.e. a row in a table, in the database.
     *
     * @param obj the data object to delete in the database, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(Matiere obj) throws TorqueException
    {
        int result = doDelete(buildCriteria(obj.getPrimaryKey()));
        obj.setDeleted(true);
        return result;
    }

    /**
     * Deletes a data object, i.e. a row in a table, in the database.
     * This method is to be used during a transaction, otherwise use the
     * doDelete(Matiere) method.
     *
     * @param obj the data object to delete in the database, not null.
     * @param con the connection to use, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(Matiere obj, Connection con)
        throws TorqueException
    {
        int result = doDelete(buildCriteria(obj.getPrimaryKey()), con);
        obj.setDeleted(true);
        return result;
    }

    /**
     * Deletes data objects, i.e. rows in a table, in the database.
     *
     * @param objects the data object to delete in the database, not null,
     *        may not contain null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(Collection<Matiere> objects)
            throws TorqueException
    {
        int result = doDelete(buildPkCriteria(objects));
        for (Matiere object : objects)
        {
            object.setDeleted(true);
        }
        return result;
    }

    /**
     * Deletes data objects, i.e. rows in a table, in the database.
     * This method uses the passed connection to delete the rows;
     * if a transaction is open in the connection, the deletion happens inside
     * this transaction.
     *
     * @param objects the data objects to delete in the database, not null,
     *        may not contain null.
     * @param con the connection to use for deleting, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(
            Collection<Matiere> objects,
            Connection con)
        throws TorqueException
    {
        int result = doDelete(buildPkCriteria(objects), con);
        for (Matiere object : objects)
        {
            object.setDeleted(true);
        }
        return result;
    }

    /**
     * Deletes a row in the database.
     *
     * @param pk the ObjectKey that identifies the row to delete.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(ObjectKey pk) throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatierePeer.DATABASE_NAME);
            int deletedRows = doDelete(pk, connection);
            Transaction.commit(connection);
            connection = null;
            return deletedRows;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Deletes a row in the database.
     * This method is to be used during a transaction,
     * otherwise use the doDelete(ObjectKey) method.
     *
     * @param pk the ObjectKey that identifies the row to delete.
     * @param con the connection to use for deleting, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(ObjectKey pk, Connection con)
        throws TorqueException
    {
        return doDelete(buildCriteria(pk), con);
    }

    /** 
     * Build a Criteria object which selects all objects which have a given
     * primary key.
     *
     * @param pk the primary key value to build the criteria from, not null.
     */
    public Criteria buildCriteria(ObjectKey pk)
    {
        Criteria criteria = new Criteria();
        criteria.and(MatierePeer.MATIERE_ID, pk);
        return criteria;
     }

    /** 
     * Build a Criteria object which selects all objects which primary keys
     * are contained in the passed collection.
     *
     * @param pks the primary key values to build the criteria from, not null,
     *        may not contain null.
     */
    public Criteria buildCriteria(Collection<ObjectKey> pks)
    {
        Criteria criteria = new Criteria();
        criteria.andIn(MatierePeer.MATIERE_ID, pks);
        return criteria;
     }


    /** 
     * Build a Criteria object which selects all passed objects using their
     * primary key. Objects which do not yet have a primary key are ignored.
     *
     * @param objects the objects to build the criteria from, not null,
     *        may not contain null.
     */
    public Criteria buildPkCriteria(
            Collection<Matiere> objects)
    {
        List<ObjectKey> pks = new ArrayList<ObjectKey>(objects.size());
        for (Matiere object : objects)
        {
            ObjectKey pk = object.getPrimaryKey();
            if (pk != null)
            {
                pks.add(pk);
            }
        }
        return buildCriteria(pks);
    }

    /** 
     * Build a Criteria object from the data object for this peer.
     * The primary key columns are only added if the object is not new.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public Criteria buildCriteria(Matiere obj)
    {
        Criteria criteria = new Criteria(MatierePeer.DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.and(MatierePeer.MATIERE_ID, obj.getMatiereId());
        }
        criteria.and(MatierePeer.NOM, obj.getNom());
        return criteria;
    }

    /** 
     * Build a Criteria object from the data object for this peer,
     * skipping all binary columns.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public Criteria buildSelectCriteria(Matiere obj)
    {
        Criteria criteria = new Criteria(MatierePeer.DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.and(MatierePeer.MATIERE_ID, obj.getMatiereId());
        }
        criteria.and(MatierePeer.NOM, obj.getNom());
        return criteria;
    }

    /** 
     * Returns the contents of the object as ColumnValues object.
     * Primary key columns which are generated on insertion are not
     * added to the returned object if they still have their initial
     * value. Also, columns which have the useDatabaseDefaultValue
     * flag set to true are also not added to the returned object
     * if they still have their initial value.
     *
     * @throws TorqueException if the table map cannot be retrieved
     *         (should not happen).
     */
    public ColumnValues buildColumnValues(Matiere matiere)
            throws TorqueException
    {
        ColumnValues columnValues = new ColumnValues();
        if (!matiere.isNew() 
            || matiere.getMatiereId() != 0)
        {
            columnValues.put(
                    MatierePeer.MATIERE_ID,
                    new JdbcTypedValue(
                        matiere.getMatiereId(),
                        4));
        }
        columnValues.put(
                MatierePeer.NOM,
                new JdbcTypedValue(
                    matiere.getNom(),
                    12));
        return columnValues;
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public Matiere retrieveByPK(int pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk));
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public Matiere retrieveByPK(int pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        return retrieveByPK(SimpleKey.keyFor(pk), con);
    }
    
    
    

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public Matiere retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(MatierePeer.DATABASE_NAME);
            Matiere result = retrieveByPK(pk, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Retrieve a single object by pk
     *
     * @param pk the primary key
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     * @throws NoRowsException Primary key was not found in database.
     * @throws TooManyRowsException Primary key was not found in database.
     */
    public Matiere retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List<Matiere> v = doSelect(criteria, con);
        if (v.size() == 0)
        {
            throw new NoRowsException("Failed to select a row.");
        }
        else if (v.size() > 1)
        {
            throw new TooManyRowsException("Failed to select only one row.");
        }
        else
        {
            return (Matiere)v.get(0);
        }
    }


    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Matiere> retrieveByPKs(Collection<ObjectKey> pks)
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(MatierePeer.DATABASE_NAME);
            List<Matiere> result = retrieveByPKs(pks, connection);
            Transaction.commit(connection);
            connection = null;
            return result;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /**
     * Retrieve multiple objects by pk
     *
     * @param pks List of primary keys
     * @param dbcon the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<Matiere> retrieveByPKs(
                Collection<ObjectKey> pks,
                Connection dbcon)
            throws TorqueException
    {
        if (pks == null || pks.size() == 0)
        {
            return new ArrayList<Matiere>();
        }
        Criteria criteria = buildCriteria(pks);
        List<Matiere> result = doSelect(criteria, dbcon);
        return result;
    }




    /** 
     * Saves the passed collection as linked objects.
     * This means the following is done:
     * <ul>
     *  <li>
     *    The current collection of objects which are linked to toLinkTo
     *    and which are also in the list toSave is read from the database
     *    into the list intersection.
     *  </li>
     *  <li>
     *    All objects in toSave which are not in intersection are inserted.
     *  </li>
     *  <li>
     *    All objects in intersection are updated with the 
     *    corresponding values in toSave and saved.
     *  </li>
     *  <li>
     *    All objects in the database which are linked to toLinkTo but are 
     *    not in toSave are deleted from the database.
     *  </li>
     * </ul>
     *
     * @param toLinkTo the object which collections should be set with the
     *        values in toSave.
     * @param toSave Contains the objects to save, not null, 
     *        may not contain null.
     *
     * @throws TorqueException if an error accessing the database occurs.
     * @throws NullPointerException if toFill is null or contains null elements.
     */
    public void setAndSaveProfesseurs(
            Matiere toLinkTo,
            Collection<Professeur> toSave) 
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatierePeer.DATABASE_NAME);
            setAndSaveProfesseurs(toLinkTo, toSave, connection);
            Transaction.commit(connection);
            connection = null;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /** 
     * Saves the passed collection as linked objects.
     * This means the following is done:
     * <ul>
     *  <li>
     *    The current collection of objects which are linked to toLinkTo
     *    and which are also in the list toSave is read from the database
     *    into the list intersection.
     *  </li>
     *  <li>
     *    All objects in toSave which are not in intersection are inserted.
     *  </li>
     *  <li>
     *    All objects in intersection are updated with the 
     *    corresponding values in toSave and saved.
     *  </li>
     *  <li>
     *    All objects in the database which are linked to toLinkTo but are 
     *    not in toSave are deleted from the database.
     *  </li>
     * </ul>
     *
     * @param toLinkTo the object which collections should be set with the
     *        values in toSave.
     * @param toSave Contains the objects to save, not null, 
     *        may not contain null.
     * @param connection the database connection to use.
     *
     * @throws TorqueException if an error accessing the database occurs.
     * @throws NullPointerException if toFill is null or contains null elements.
     */
    public void setAndSaveProfesseurs(
            Matiere toLinkTo,
            Collection<Professeur> toSave,
            Connection connection) 
        throws TorqueException
    {
        ObjectKey localKey = toLinkTo.getPrimaryKey();

        Criteria criteria = new Criteria();
        Criterion onlyReferencingCriterion = new Criterion(
                ProfesseurPeer.MATIERE_ID, 
                localKey);
        criteria.where(onlyReferencingCriterion);
        Set<ObjectKey> toSaveKeys = new HashSet<ObjectKey>();
        for (Professeur toSaveElement : toSave)
        {
            ObjectKey toSaveKey = toSaveElement.getPrimaryKey();
            if (toSaveKey.getValue() != null)
            {
                toSaveKeys.add(toSaveKey);
            }
        }
        criteria.and(ProfesseurPeer.PROFESSEUR_ID, toSaveKeys, Criteria.IN);
        List<Professeur> intersection
                = ProfesseurPeer.doSelect(criteria, connection);
        List<Professeur> linkedCache;
        if (toLinkTo.isProfesseursInitialized()) {
            linkedCache = toLinkTo.getProfesseurs();
            linkedCache.clear();
        }
        else
        {
            linkedCache = toLinkTo.initProfesseurs();
        }
        for (Professeur toSaveElement : toSave)
        {
            int listIndex = intersection.indexOf(toSaveElement);
            if (listIndex == -1)
            {
                toLinkTo.addProfesseur(toSaveElement);
                toSaveElement.save(connection);
            }
            else
            {
                toLinkTo.addProfesseur(toSaveElement);
                toSaveElement.setNew(false);
                if (!toSaveElement.valueEquals(intersection.get(listIndex)))
                {
                    //force saving if content differs
                    toSaveElement.setModified(true);
                }
                toSaveElement.save(connection);
            }
            toSaveKeys.add(toSaveElement.getPrimaryKey());
        }
        
        // delete elements not in intersection
        Criteria deleteCriteria = new Criteria();
        deleteCriteria.where(onlyReferencingCriterion);
        deleteCriteria.and(ProfesseurPeer.PROFESSEUR_ID, toSaveKeys, Criteria.NOT_IN);
        ProfesseurPeer.doDelete(deleteCriteria, connection);
    }
    /** 
     * Saves the passed collection as linked objects.
     * This means the following is done:
     * <ul>
     *  <li>
     *    The current collection of objects which are linked to toLinkTo
     *    and which are also in the list toSave is read from the database
     *    into the list intersection.
     *  </li>
     *  <li>
     *    All objects in toSave which are not in intersection are inserted.
     *  </li>
     *  <li>
     *    All objects in intersection are updated with the 
     *    corresponding values in toSave and saved.
     *  </li>
     *  <li>
     *    All objects in the database which are linked to toLinkTo but are 
     *    not in toSave are deleted from the database.
     *  </li>
     * </ul>
     *
     * @param toLinkTo the object which collections should be set with the
     *        values in toSave.
     * @param toSave Contains the objects to save, not null, 
     *        may not contain null.
     *
     * @throws TorqueException if an error accessing the database occurs.
     * @throws NullPointerException if toFill is null or contains null elements.
     */
    public void setAndSaveMatiereClasses(
            Matiere toLinkTo,
            Collection<MatiereClasse> toSave) 
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatierePeer.DATABASE_NAME);
            setAndSaveMatiereClasses(toLinkTo, toSave, connection);
            Transaction.commit(connection);
            connection = null;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /** 
     * Saves the passed collection as linked objects.
     * This means the following is done:
     * <ul>
     *  <li>
     *    The current collection of objects which are linked to toLinkTo
     *    and which are also in the list toSave is read from the database
     *    into the list intersection.
     *  </li>
     *  <li>
     *    All objects in toSave which are not in intersection are inserted.
     *  </li>
     *  <li>
     *    All objects in intersection are updated with the 
     *    corresponding values in toSave and saved.
     *  </li>
     *  <li>
     *    All objects in the database which are linked to toLinkTo but are 
     *    not in toSave are deleted from the database.
     *  </li>
     * </ul>
     *
     * @param toLinkTo the object which collections should be set with the
     *        values in toSave.
     * @param toSave Contains the objects to save, not null, 
     *        may not contain null.
     * @param connection the database connection to use.
     *
     * @throws TorqueException if an error accessing the database occurs.
     * @throws NullPointerException if toFill is null or contains null elements.
     */
    public void setAndSaveMatiereClasses(
            Matiere toLinkTo,
            Collection<MatiereClasse> toSave,
            Connection connection) 
        throws TorqueException
    {
        ObjectKey localKey = toLinkTo.getPrimaryKey();

        Criteria criteria = new Criteria();
        Criterion onlyReferencingCriterion = new Criterion(
                MatiereClassePeer.MATIERE_ID, 
                localKey);
        criteria.where(onlyReferencingCriterion);
        Set<ObjectKey> toSaveKeys = new HashSet<ObjectKey>();
        for (MatiereClasse toSaveElement : toSave)
        {
            ObjectKey toSaveKey = toSaveElement.getPrimaryKey();
            if (toSaveKey.getValue() != null)
            {
                toSaveKeys.add(toSaveKey);
            }
        }
        criteria.and(MatiereClassePeer.MATIERE_CLASSE_ID, toSaveKeys, Criteria.IN);
        List<MatiereClasse> intersection
                = MatiereClassePeer.doSelect(criteria, connection);
        List<MatiereClasse> linkedCache;
        if (toLinkTo.isMatiereClassesInitialized()) {
            linkedCache = toLinkTo.getMatiereClasses();
            linkedCache.clear();
        }
        else
        {
            linkedCache = toLinkTo.initMatiereClasses();
        }
        for (MatiereClasse toSaveElement : toSave)
        {
            int listIndex = intersection.indexOf(toSaveElement);
            if (listIndex == -1)
            {
                toLinkTo.addMatiereClasse(toSaveElement);
                toSaveElement.save(connection);
            }
            else
            {
                toLinkTo.addMatiereClasse(toSaveElement);
                toSaveElement.setNew(false);
                if (!toSaveElement.valueEquals(intersection.get(listIndex)))
                {
                    //force saving if content differs
                    toSaveElement.setModified(true);
                }
                toSaveElement.save(connection);
            }
            toSaveKeys.add(toSaveElement.getPrimaryKey());
        }
        
        // delete elements not in intersection
        Criteria deleteCriteria = new Criteria();
        deleteCriteria.where(onlyReferencingCriterion);
        deleteCriteria.and(MatiereClassePeer.MATIERE_CLASSE_ID, toSaveKeys, Criteria.NOT_IN);
        MatiereClassePeer.doDelete(deleteCriteria, connection);
    }
    /** 
     * Saves the passed collection as linked objects.
     * This means the following is done:
     * <ul>
     *  <li>
     *    The current collection of objects which are linked to toLinkTo
     *    and which are also in the list toSave is read from the database
     *    into the list intersection.
     *  </li>
     *  <li>
     *    All objects in toSave which are not in intersection are inserted.
     *  </li>
     *  <li>
     *    All objects in intersection are updated with the 
     *    corresponding values in toSave and saved.
     *  </li>
     *  <li>
     *    All objects in the database which are linked to toLinkTo but are 
     *    not in toSave are deleted from the database.
     *  </li>
     * </ul>
     *
     * @param toLinkTo the object which collections should be set with the
     *        values in toSave.
     * @param toSave Contains the objects to save, not null, 
     *        may not contain null.
     *
     * @throws TorqueException if an error accessing the database occurs.
     * @throws NullPointerException if toFill is null or contains null elements.
     */
    public void setAndSaveNotes(
            Matiere toLinkTo,
            Collection<Note> toSave) 
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatierePeer.DATABASE_NAME);
            setAndSaveNotes(toLinkTo, toSave, connection);
            Transaction.commit(connection);
            connection = null;
        }
        finally
        {
            if (connection != null)
            {
                Transaction.safeRollback(connection);
            }
        }
    }

    /** 
     * Saves the passed collection as linked objects.
     * This means the following is done:
     * <ul>
     *  <li>
     *    The current collection of objects which are linked to toLinkTo
     *    and which are also in the list toSave is read from the database
     *    into the list intersection.
     *  </li>
     *  <li>
     *    All objects in toSave which are not in intersection are inserted.
     *  </li>
     *  <li>
     *    All objects in intersection are updated with the 
     *    corresponding values in toSave and saved.
     *  </li>
     *  <li>
     *    All objects in the database which are linked to toLinkTo but are 
     *    not in toSave are deleted from the database.
     *  </li>
     * </ul>
     *
     * @param toLinkTo the object which collections should be set with the
     *        values in toSave.
     * @param toSave Contains the objects to save, not null, 
     *        may not contain null.
     * @param connection the database connection to use.
     *
     * @throws TorqueException if an error accessing the database occurs.
     * @throws NullPointerException if toFill is null or contains null elements.
     */
    public void setAndSaveNotes(
            Matiere toLinkTo,
            Collection<Note> toSave,
            Connection connection) 
        throws TorqueException
    {
        ObjectKey localKey = toLinkTo.getPrimaryKey();

        Criteria criteria = new Criteria();
        Criterion onlyReferencingCriterion = new Criterion(
                NotePeer.MATIERE_ID, 
                localKey);
        criteria.where(onlyReferencingCriterion);
        Set<ObjectKey> toSaveKeys = new HashSet<ObjectKey>();
        for (Note toSaveElement : toSave)
        {
            ObjectKey toSaveKey = toSaveElement.getPrimaryKey();
            if (toSaveKey.getValue() != null)
            {
                toSaveKeys.add(toSaveKey);
            }
        }
        criteria.and(NotePeer.NOTE_ID, toSaveKeys, Criteria.IN);
        List<Note> intersection
                = NotePeer.doSelect(criteria, connection);
        List<Note> linkedCache;
        if (toLinkTo.isNotesInitialized()) {
            linkedCache = toLinkTo.getNotes();
            linkedCache.clear();
        }
        else
        {
            linkedCache = toLinkTo.initNotes();
        }
        for (Note toSaveElement : toSave)
        {
            int listIndex = intersection.indexOf(toSaveElement);
            if (listIndex == -1)
            {
                toLinkTo.addNote(toSaveElement);
                toSaveElement.save(connection);
            }
            else
            {
                toLinkTo.addNote(toSaveElement);
                toSaveElement.setNew(false);
                if (!toSaveElement.valueEquals(intersection.get(listIndex)))
                {
                    //force saving if content differs
                    toSaveElement.setModified(true);
                }
                toSaveElement.save(connection);
            }
            toSaveKeys.add(toSaveElement.getPrimaryKey());
        }
        
        // delete elements not in intersection
        Criteria deleteCriteria = new Criteria();
        deleteCriteria.where(onlyReferencingCriterion);
        deleteCriteria.and(NotePeer.NOTE_ID, toSaveKeys, Criteria.NOT_IN);
        NotePeer.doDelete(deleteCriteria, connection);
    }


}
