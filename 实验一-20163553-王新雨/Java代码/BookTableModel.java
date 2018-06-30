package librarySystem;

import java.sql.*; 
import java.util.*; 
 
/* 
 * 图书表模型 
 * */ 
import javax.swing.table.*; 
@SuppressWarnings("serial") 
 public class BookTableModel extends AbstractTableModel{ 
  //表的元素 
  private Vector<Vector<String>> rowData; 
  private Vector<String> colName; 
  // 数据库 
  private PreparedStatement stmt; 
  private ResultSet result; 
  String url="jdbc:sqlserver://127.0.0.1:1433;DatabaseName=students";
  String user="log1"; 
  String password="123"; 
  Connection con=DriverManager.getConnection(url,user,password); 
  public BookTableModel(String sql) throws SQLException{ 
    this.initData(sql); 
  } 
  public BookTableModel() throws SQLException{ 
    this.initData("SELECT * FROM Student"); 
  } 
  public void initData(String sql) throws SQLException{ 
    setRowData(new Vector<Vector<String>>()); 
    setColName(new Vector<String>()); 
    getColName().add("学号"); 
    getColName().add("姓名"); 
    getColName().add("性别"); 
    getColName().add("年龄"); 
    getColName().add("班级"); 
    getColName().add("电话"); 
    
    /* 
     * 数据库的导入 
     * */ 
    try { 
      Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
    } catch (ClassNotFoundException e) { 
      // TODO Auto-generated catch block 
    	
      e.printStackTrace(); 
    } 
    
    stmt = con.prepareStatement(sql); 
    result=stmt.executeQuery(); 
    importSQL(); 
  } 
  void importSQL() throws SQLException{ 
    // TODO Auto-generated method stub 
    @SuppressWarnings("unused") 
    boolean signNull=true; 
    while(result.next()){ 
      Vector<String> item=new Vector<String>(); 
      for(int i=1;i<=6;i++){ 
        item.add(result.getString(i)); 
      } 
      getRowData().add(item); 
      signNull=false; 
    } 
    result.close(); 
  } 
  @Override 
  public int getColumnCount() {//得到列数 
    // TODO Auto-generated method stub 
    return this.colName.size(); 
  } 
 
  @Override 
  public int getRowCount() {//得到行数 
    // TODO Auto-generated method stub 
    return this.rowData.size(); 
  } 
 
  @Override 
  public Object getValueAt(int row, int col) {//得到某行某列的数据 
    // TODO Auto-generated method stub 
    return (this.rowData.get(row)).get(col); 
  } 
 
  @Override 
  public String getColumnName(int column) { 
    // TODO Auto-generated method stub 
    return this.colName.get(column); 
  } 
   
  public Vector<Vector<String>> getRowData() { 
    return rowData; 
  } 
  public void setRowData(Vector<Vector<String>> rowData) { 
    this.rowData = rowData; 
  } 
  public Vector<String> getColName() { 
    return colName; 
  } 
  public void setColName(Vector<String> colName) { 
    this.colName = colName; 
  } 
  public void addBook(String sql){ 
    try { stmt = con.prepareStatement(sql); 
    
      stmt.executeUpdate(); 
    } catch (SQLException e) { 
      // TODO Auto-generated catch block 
      e.printStackTrace(); 
    } 
  //initData("SELECT * FROM book_info"); 
  } 
  public void deleteBook(String sql){ 
    try { stmt = con.prepareStatement(sql); 
    
    stmt.executeUpdate(); 
      
    } catch (SQLException e1) { 
      // TODO Auto-generated catch block 
      e1.printStackTrace(); 
    } 
  } 
} 
