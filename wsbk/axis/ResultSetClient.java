import com.n_topus.DBS_RS.*;
import javax.xml.rpc.Stub;
import java.net.URL;
import org.apache.axis.utils.Options;

public class ResultSetClient {

public static void main(String[]args)throws Exception{
  Options opts = new Options(args);
  args = opts.getRemainingArgs();
  if(args==null){
    System.err.println(
 "Usage: ResultSetClient -uUSER -wPWD -hHOST -pPORT -s PATH qName qArgs");
    System.err.println(
 "e.g. -utjm -wtjm -hlocalhost -p65432 GET_AmaAuth 123456789X");
    System.exit(1);
  }
  _doSQLRequest_DBServerCallParams dbcp =
      new _doSQLRequest_DBServerCallParams();
  dbcp.setDbParam(args);
  _doSQLRequest request = new _doSQLRequest();
  request.setDBServerCallParams(dbcp);

  try{
    ResultSetServiceLocator sL=new ResultSetServiceLocator();
    ResultSetPortType serv = sL.getResultSetPort();

    ResultSetBindingStub stub = (ResultSetBindingStub)serv;
    stub._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,opts.getURL());
    stub.setUsername(opts.getUser());
    stub.setPassword(opts.getPassword());

    _doSQLResponse dsr=stub.getResultSet(request);
    _doSQLResponse_table table = dsr.getTable();
    _doSQLResponse_table_tr[] rows= table.getTr();
    for(int i=0;i<rows.length;i++)
     if(rows[i].isHeaderRow())showRow(rows[i].getTh());
     else showRow(rows[i].getTd());
  }catch(Exception ex){ex.printStackTrace();}
}
public static void showRow(String[]row){
  if(row==null || row.length==0) return;
  System.out.print(row[0]);
  for(int j=1;j<row.length;j++)
    System.out.print("\t"+row[j]);
  System.out.println();
}
}
