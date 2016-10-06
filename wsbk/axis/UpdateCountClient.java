import com.n_topus.DBS.*;
import java.net.URL;
import org.apache.axis.utils.Options;
import javax.xml.rpc.Stub;

public class UpdateCountClient {

public static void main(String[]args)throws Exception{
  Options opts = new Options(args);
  args = opts.getRemainingArgs();
  if(args==null){
    System.err.println(
 "Usage: UpdateCountClient -uUSER -wPWD -hHOST -pPORT -sPATH qName qArgs");
    System.err.println(
 "e.g. -utjm -wtjm -hlocalhost -p65432 INS_AmaAuth 123456789X J_Schmoe");
    System.exit(1);
  }
  _doSQLRequest_DBServerCallParams dbcp =
      new _doSQLRequest_DBServerCallParams();
  dbcp.setDbParam(args);
  _doSQLRequest request = new _doSQLRequest();
  request.setDBServerCallParams(dbcp);

  try{
    UpdateCountServiceLocator sL=new UpdateCountServiceLocator();
    UpdateCountPortType serv = sL.getUpdateCountPort();

    UpdateCountBindingStub stub = (UpdateCountBindingStub)serv;
    stub._setProperty(javax.xml.rpc.Stub.ENDPOINT_ADDRESS_PROPERTY,
                      opts.getURL());
    stub.setUsername(opts.getUser());
    stub.setPassword(opts.getPassword());

    _doSQLResponse dsr=stub.getUpdateCount(request);
    System.out.println("The update count is "+dsr.getSpan());
  }catch(Exception ex){ex.printStackTrace();}
}

}
