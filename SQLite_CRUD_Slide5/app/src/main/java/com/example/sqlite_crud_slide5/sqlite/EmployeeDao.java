package com.example.sqlite_crud_slide5.sqlite;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.sqlite_crud_slide5.model.Employee;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDao {
    private SQLiteDatabase db;

    public EmployeeDao(Context context) {
        DBHelped helper = new DBHelped(context);

        db = helper.getWritableDatabase();

    }
    @SuppressLint("Range")
    public List<Employee> get(String sql, String ...selectArgs) {
        List<Employee> list = new ArrayList<>();
        Cursor cursor = db.rawQuery(sql,selectArgs);
        while (cursor.moveToNext()){
            Employee emp = new Employee();
            emp.setId(cursor.getString(cursor.getColumnIndex("id")));
            emp.setName(cursor.getString(cursor.getColumnIndex("name")));
            emp.setDiem(cursor.getFloat(cursor.getColumnIndex("diem")));

            list.add(emp);
        }
        return list;
    }
    public  List<Employee> getAll(){
        String sql = "SELECT * FROM nhanvien";
        return  get(sql);
    }
    public Employee getByid(String id){
        String sql = "SELECT * FROM sinhvien WHERE id=?";
        List<Employee> list = get(sql,id);
        return list.get(0);
    }
    public  long insert(Employee emp){
        ContentValues values = new ContentValues();
        values.put("id",emp.getId());
        values.put("name",emp.getName());
        values.put("diem",emp.getDiem());
        return  db.insert("sinhvien",null,values);
    }
    public  long update(Employee emp){
        ContentValues values = new ContentValues();

        values.put("name",emp.getName());
        values.put("diem",emp.getDiem());
        return  db.update("sinhvien",values,"id=?",new String[]{emp.getId()});
    }
    public int delete(String id){
        return db.delete("sinhvien","id=?",new String[]{id});
    }
}
