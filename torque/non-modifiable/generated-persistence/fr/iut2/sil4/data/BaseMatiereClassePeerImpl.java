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
 * Table des matieres suivi par une classe
 *
 * The skeleton for this class was autogenerated by Torque on:
 *
 * [Mon Jan 20 16:44:53 CET 2014]
 *
 * You should not use this class directly.  It should not even be
 * extended; all references should be to MatiereClassePeer
 */

public abstract class BaseMatiereClassePeerImpl
    extends org.apache.torque.util.BasePeerImpl<MatiereClasse>
{
    /** The class log. */
    private static Log log = LogFactory.getLog(BaseMatiereClassePeerImpl.class);

    /** Serial version */
    private static final long serialVersionUID = 1390232693169L;



    /**
     * Constructor.
     * The recordMapper, tableMap and databaseName fields are correctly
     * initialized.
     */
    public BaseMatiereClassePeerImpl()
    {
        this(new MatiereClasseRecordMapper(),
            MatiereClassePeer.TABLE,
            MatiereClassePeer.DATABASE_NAME);
    }

    /**
     * Constructor providing the objects to be injected as parameters.
     *
     * @param recordMapper a record mapper to map JDBC result sets to objects
     * @param tableMap the default table map
     * @param databaseName the name of the database
     */
    public BaseMatiereClassePeerImpl(
            RecordMapper<MatiereClasse> recordMapper, 
            TableMap tableMap,
            String databaseName)
    {
        super(recordMapper, tableMap, databaseName);
    }


    /**
     * Selects MatiereClasse objects from the database which have
     * the same content as the passed object.
     *
     * @return The list of selected objects, not null.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<MatiereClasse> doSelect(MatiereClasse obj)
            throws TorqueException
    {
        return doSelect(buildSelectCriteria(obj));
    }

    /**
     * Selects at most one MatiereClasse object from the database
     * which has the same content as the passed object.
     *
     * @return the selected Object, or null if no object was selected.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public MatiereClasse doSelectSingleRecord(
                MatiereClasse obj)
            throws TorqueException
    {
        List<MatiereClasse> matiereClasseList = doSelect(obj);
        MatiereClasse matiereClasse = null;
        if (matiereClasseList.size() > 1)
        {
            throw new TooManyRowsException("Object " + obj 
                + " matched more than one record");
        }
        if (!matiereClasseList.isEmpty())
        {
            matiereClasse = matiereClasseList.get(0);
        }
        return matiereClasse;
    }

    /**
     * Returns a new instance of the Data object class
     */
    public MatiereClasse getDbObjectInstance()
    {
        return new MatiereClasse();
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
                    MatiereClassePeer.DATABASE_NAME);
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
    public void doInsert(MatiereClasse obj) throws TorqueException
    {
        obj.setPrimaryKey(doInsert(buildColumnValues(obj)));
        obj.setNew(false);
        obj.setModified(false);
    }

    /**
     * Method to do inserts.  This method is to be used during a transaction,
     * otherwise use the doInsert(MatiereClasse) method.  It will take
     * care of the connection details internally.
     *
     * @param obj the data object to insert into the database.
     * @param con the connection to use
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public void doInsert(MatiereClasse obj, Connection con)
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
                    MatiereClassePeer.DATABASE_NAME);
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
                = new Criteria(MatiereClassePeer.DATABASE_NAME);
        correctBooleans(columnValues);

        selectCriteria.where(
                MatiereClassePeer.MATIERE_CLASSE_ID,
                columnValues.remove(MatiereClassePeer.MATIERE_CLASSE_ID).getValue());


        int rowCount = doUpdate(selectCriteria, columnValues, con);
        return rowCount;
    }

    /**
     * Updates an MatiereClasse in the database.
     * The primary key is used to identify the object to update.
     *
     * @param obj the data object to update in the database.
     *
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(MatiereClasse obj) throws TorqueException
    {
        ColumnValues columnValues = buildColumnValues(obj);
        int result = doUpdate(columnValues);
        obj.setModified(false);
        return result;
    }

    /**
     * Updates a MatiereClasse in the database.
     * The primary key is used to identify the object to update.
     * This method is to be used during a transaction,
     * otherwise the doUpdate(MatiereClasse) method can be used.
     *
     * @param obj the data object to update in the database.
     * @param con the connection to use, not null.
     
     * @return the number of affected rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doUpdate(MatiereClasse obj, Connection con)
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
    public int doDelete(MatiereClasse obj) throws TorqueException
    {
        int result = doDelete(buildCriteria(obj.getPrimaryKey()));
        obj.setDeleted(true);
        return result;
    }

    /**
     * Deletes a data object, i.e. a row in a table, in the database.
     * This method is to be used during a transaction, otherwise use the
     * doDelete(MatiereClasse) method.
     *
     * @param obj the data object to delete in the database, not null.
     * @param con the connection to use, not null.
     *
     * @return the number of deleted rows.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public int doDelete(MatiereClasse obj, Connection con)
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
    public int doDelete(Collection<MatiereClasse> objects)
            throws TorqueException
    {
        int result = doDelete(buildPkCriteria(objects));
        for (MatiereClasse object : objects)
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
            Collection<MatiereClasse> objects,
            Connection con)
        throws TorqueException
    {
        int result = doDelete(buildPkCriteria(objects), con);
        for (MatiereClasse object : objects)
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
                    MatiereClassePeer.DATABASE_NAME);
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
        criteria.and(MatiereClassePeer.MATIERE_CLASSE_ID, pk);
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
        criteria.andIn(MatiereClassePeer.MATIERE_CLASSE_ID, pks);
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
            Collection<MatiereClasse> objects)
    {
        List<ObjectKey> pks = new ArrayList<ObjectKey>(objects.size());
        for (MatiereClasse object : objects)
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
    public Criteria buildCriteria(MatiereClasse obj)
    {
        Criteria criteria = new Criteria(MatiereClassePeer.DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.and(MatiereClassePeer.MATIERE_CLASSE_ID, obj.getMatiereClasseId());
        }
        criteria.and(MatiereClassePeer.CLASSE_ID, obj.getClasseId());
        criteria.and(MatiereClassePeer.MATIERE_ID, obj.getMatiereId());
        return criteria;
    }

    /** 
     * Build a Criteria object from the data object for this peer,
     * skipping all binary columns.
     *
     * @param obj the object to build the criteria from, not null.
     */
    public Criteria buildSelectCriteria(MatiereClasse obj)
    {
        Criteria criteria = new Criteria(MatiereClassePeer.DATABASE_NAME);
        if (!obj.isNew())
        {
            criteria.and(MatiereClassePeer.MATIERE_CLASSE_ID, obj.getMatiereClasseId());
        }
        criteria.and(MatiereClassePeer.CLASSE_ID, obj.getClasseId());
        criteria.and(MatiereClassePeer.MATIERE_ID, obj.getMatiereId());
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
    public ColumnValues buildColumnValues(MatiereClasse matiereClasse)
            throws TorqueException
    {
        ColumnValues columnValues = new ColumnValues();
        if (!matiereClasse.isNew() 
            || matiereClasse.getMatiereClasseId() != 0)
        {
            columnValues.put(
                    MatiereClassePeer.MATIERE_CLASSE_ID,
                    new JdbcTypedValue(
                        matiereClasse.getMatiereClasseId(),
                        4));
        }
        columnValues.put(
                MatiereClassePeer.CLASSE_ID,
                new JdbcTypedValue(
                    matiereClasse.getClasseId(),
                    4));
        columnValues.put(
                MatiereClassePeer.MATIERE_ID,
                new JdbcTypedValue(
                    matiereClasse.getMatiereId(),
                    4));
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
    public MatiereClasse retrieveByPK(int pk)
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
    public MatiereClasse retrieveByPK(int pk, Connection con)
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
    public MatiereClasse retrieveByPK(ObjectKey pk)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(MatiereClassePeer.DATABASE_NAME);
            MatiereClasse result = retrieveByPK(pk, connection);
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
    public MatiereClasse retrieveByPK(ObjectKey pk, Connection con)
        throws TorqueException, NoRowsException, TooManyRowsException
    {
        Criteria criteria = buildCriteria(pk);
        List<MatiereClasse> v = doSelect(criteria, con);
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
            return (MatiereClasse)v.get(0);
        }
    }


    /**
     * Retrieve a multiple objects by pk
     *
     * @param pks List of primary keys
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<MatiereClasse> retrieveByPKs(Collection<ObjectKey> pks)
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(MatiereClassePeer.DATABASE_NAME);
            List<MatiereClasse> result = retrieveByPKs(pks, connection);
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
    public List<MatiereClasse> retrieveByPKs(
                Collection<ObjectKey> pks,
                Connection dbcon)
            throws TorqueException
    {
        if (pks == null || pks.size() == 0)
        {
            return new ArrayList<MatiereClasse>();
        }
        Criteria criteria = buildCriteria(pks);
        List<MatiereClasse> result = doSelect(criteria, dbcon);
        return result;
    }


    /**
     * Selects a collection of dbObjectClassName objects pre-filled with their
     * Matiere objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<MatiereClasse> doSelectJoinMatiere(Criteria criteria)
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatiereClassePeer.DATABASE_NAME);
            List<MatiereClasse> result
                    = MatiereClassePeer.doSelectJoinMatiere(criteria, connection);
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
     * Selects a collection of MatiereClasse objects pre-filled with their
     * Matiere objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<MatiereClasse> doSelectJoinMatiere(
            Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        addSelectColumns(criteria);
        fr.iut2.sil4.data.MatierePeer.addSelectColumns(criteria);

        CompositeMapper compositeMapper = new CompositeMapper();
        compositeMapper.addMapper(
                new MatiereClasseRecordMapper(),
                0);
        compositeMapper.addMapper(
                new MatiereRecordMapper(),
                MatiereClassePeer.numColumns);
        criteria.addJoin(MatiereClassePeer.MATIERE_ID,
            fr.iut2.sil4.data.MatierePeer.MATIERE_ID);

        correctBooleans(criteria);

        List<MatiereClasse> result = new ArrayList<MatiereClasse>();
        List<List<Object>> rawResult = doSelect(
                criteria, compositeMapper, conn);
        for (List<Object> rawResultRow : rawResult)
        {
            MatiereClasse obj1 = (MatiereClasse) rawResultRow.get(0);
            Matiere obj2 = (Matiere) rawResultRow.get(1);

            boolean newObject = true;
            for (int j = 0; j < result.size(); j++)
            {
                MatiereClasse temp_obj1 = result.get(j);
                fr.iut2.sil4.data.Matiere temp_obj2 = temp_obj1.getMatiere();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addMatiereClasse(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initMatiereClasses();
                obj2.addMatiereClasse(obj1);
            }
            result.add(obj1);
        }
        return result;
    }
    /**
     * Selects a collection of dbObjectClassName objects pre-filled with their
     * Classe objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<MatiereClasse> doSelectJoinClasse(Criteria criteria)
        throws TorqueException
    {
        Connection connection = null;
        try
        {
            connection = Transaction.begin(
                    MatiereClassePeer.DATABASE_NAME);
            List<MatiereClasse> result
                    = MatiereClassePeer.doSelectJoinClasse(criteria, connection);
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
     * Selects a collection of MatiereClasse objects pre-filled with their
     * Classe objects.
     *
     * @throws TorqueException Any exceptions caught during processing will be
     *         rethrown wrapped into a TorqueException.
     */
    public List<MatiereClasse> doSelectJoinClasse(
            Criteria criteria, Connection conn)
        throws TorqueException
    {
        setDbName(criteria);

        addSelectColumns(criteria);
        fr.iut2.sil4.data.ClassePeer.addSelectColumns(criteria);

        CompositeMapper compositeMapper = new CompositeMapper();
        compositeMapper.addMapper(
                new MatiereClasseRecordMapper(),
                0);
        compositeMapper.addMapper(
                new ClasseRecordMapper(),
                MatiereClassePeer.numColumns);
        criteria.addJoin(MatiereClassePeer.CLASSE_ID,
            fr.iut2.sil4.data.ClassePeer.CLASSE_ID);

        correctBooleans(criteria);

        List<MatiereClasse> result = new ArrayList<MatiereClasse>();
        List<List<Object>> rawResult = doSelect(
                criteria, compositeMapper, conn);
        for (List<Object> rawResultRow : rawResult)
        {
            MatiereClasse obj1 = (MatiereClasse) rawResultRow.get(0);
            Classe obj2 = (Classe) rawResultRow.get(1);

            boolean newObject = true;
            for (int j = 0; j < result.size(); j++)
            {
                MatiereClasse temp_obj1 = result.get(j);
                fr.iut2.sil4.data.Classe temp_obj2 = temp_obj1.getClasse();
                if (temp_obj2.getPrimaryKey().equals(obj2.getPrimaryKey()))
                {
                    newObject = false;
                    temp_obj2.addMatiereClasse(obj1);
                    break;
                }
            }
            if (newObject)
            {
                obj2.initMatiereClasses();
                obj2.addMatiereClasse(obj1);
            }
            result.add(obj1);
        }
        return result;
    }




}
