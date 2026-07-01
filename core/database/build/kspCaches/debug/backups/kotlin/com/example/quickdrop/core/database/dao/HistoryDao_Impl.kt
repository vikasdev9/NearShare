package com.example.quickdrop.core.database.dao

import androidx.room.EntityInsertAdapter
import androidx.room.RoomDatabase
import androidx.room.coroutines.createFlow
import androidx.room.util.getColumnIndexOrThrow
import androidx.room.util.performSuspending
import androidx.sqlite.SQLiteStatement
import com.example.quickdrop.core.database.model.TransferHistoryEntity
import javax.`annotation`.processing.Generated
import kotlin.Boolean
import kotlin.Int
import kotlin.Long
import kotlin.String
import kotlin.Suppress
import kotlin.Unit
import kotlin.collections.List
import kotlin.collections.MutableList
import kotlin.collections.mutableListOf
import kotlin.reflect.KClass
import kotlinx.coroutines.flow.Flow

@Generated(value = ["androidx.room.RoomProcessor"])
@Suppress(names = ["UNCHECKED_CAST", "DEPRECATION", "REDUNDANT_PROJECTION", "REMOVAL"])
public class HistoryDao_Impl(
  __db: RoomDatabase,
) : HistoryDao {
  private val __db: RoomDatabase

  private val __insertAdapterOfTransferHistoryEntity: EntityInsertAdapter<TransferHistoryEntity>
  init {
    this.__db = __db
    this.__insertAdapterOfTransferHistoryEntity = object :
        EntityInsertAdapter<TransferHistoryEntity>() {
      protected override fun createQuery(): String =
          "INSERT OR ABORT INTO `transfer_history` (`id`,`fileName`,`fileSize`,`deviceName`,`isIncoming`,`timestamp`,`status`) VALUES (nullif(?, 0),?,?,?,?,?,?)"

      protected override fun bind(statement: SQLiteStatement, entity: TransferHistoryEntity) {
        statement.bindLong(1, entity.id)
        statement.bindText(2, entity.fileName)
        statement.bindLong(3, entity.fileSize)
        statement.bindText(4, entity.deviceName)
        val _tmp: Int = if (entity.isIncoming) 1 else 0
        statement.bindLong(5, _tmp.toLong())
        statement.bindLong(6, entity.timestamp)
        statement.bindText(7, entity.status)
      }
    }
  }

  public override suspend fun insertHistory(history: TransferHistoryEntity): Unit =
      performSuspending(__db, false, true) { _connection ->
    __insertAdapterOfTransferHistoryEntity.insert(_connection, history)
  }

  public override fun getAllHistory(): Flow<List<TransferHistoryEntity>> {
    val _sql: String = "SELECT * FROM transfer_history ORDER BY timestamp DESC"
    return createFlow(__db, false, arrayOf("transfer_history")) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        val _cursorIndexOfId: Int = getColumnIndexOrThrow(_stmt, "id")
        val _cursorIndexOfFileName: Int = getColumnIndexOrThrow(_stmt, "fileName")
        val _cursorIndexOfFileSize: Int = getColumnIndexOrThrow(_stmt, "fileSize")
        val _cursorIndexOfDeviceName: Int = getColumnIndexOrThrow(_stmt, "deviceName")
        val _cursorIndexOfIsIncoming: Int = getColumnIndexOrThrow(_stmt, "isIncoming")
        val _cursorIndexOfTimestamp: Int = getColumnIndexOrThrow(_stmt, "timestamp")
        val _cursorIndexOfStatus: Int = getColumnIndexOrThrow(_stmt, "status")
        val _result: MutableList<TransferHistoryEntity> = mutableListOf()
        while (_stmt.step()) {
          val _item: TransferHistoryEntity
          val _tmpId: Long
          _tmpId = _stmt.getLong(_cursorIndexOfId)
          val _tmpFileName: String
          _tmpFileName = _stmt.getText(_cursorIndexOfFileName)
          val _tmpFileSize: Long
          _tmpFileSize = _stmt.getLong(_cursorIndexOfFileSize)
          val _tmpDeviceName: String
          _tmpDeviceName = _stmt.getText(_cursorIndexOfDeviceName)
          val _tmpIsIncoming: Boolean
          val _tmp: Int
          _tmp = _stmt.getLong(_cursorIndexOfIsIncoming).toInt()
          _tmpIsIncoming = _tmp != 0
          val _tmpTimestamp: Long
          _tmpTimestamp = _stmt.getLong(_cursorIndexOfTimestamp)
          val _tmpStatus: String
          _tmpStatus = _stmt.getText(_cursorIndexOfStatus)
          _item =
              TransferHistoryEntity(_tmpId,_tmpFileName,_tmpFileSize,_tmpDeviceName,_tmpIsIncoming,_tmpTimestamp,_tmpStatus)
          _result.add(_item)
        }
        _result
      } finally {
        _stmt.close()
      }
    }
  }

  public override suspend fun clearHistory() {
    val _sql: String = "DELETE FROM transfer_history"
    return performSuspending(__db, false, true) { _connection ->
      val _stmt: SQLiteStatement = _connection.prepare(_sql)
      try {
        _stmt.step()
      } finally {
        _stmt.close()
      }
    }
  }

  public companion object {
    public fun getRequiredConverters(): List<KClass<*>> = emptyList()
  }
}
