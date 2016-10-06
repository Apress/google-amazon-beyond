import com.n_topus.DBS.*;
import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;
import org.apache.axis.utils.Options;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import java.net.URL;

import java.util.Iterator;

public class UpdateCountClient {

public static void main(String[]args) {
try{
  _doSQLRequest request;
  _doSQLRequest_DBServerCallParams dbcp;
  Service service= new Service();
  Call call = (Call) service.createCall();
  Options opts = new Options(args);
  args = opts.getRemainingArgs();
  if(args==null){
    System.err.println("Usage: UpdateCountClient -uUSER -wPWD queryName queryArgs...");
    System.err.println("optionally use -p8181 or other portnum, e.g. for tcpmon");
    System.exit(1);
  }
  call.setTargetEndpointAddress( new URL(opts.getURL()) );
  call.setUseSOAPAction(true);
  call.setSOAPActionURI("DBServerCall");
  QName dsr = new QName("http://n-topus.com/DBS","doSQLRequest");
  Class srClass= _doSQLRequest.class;
  call.registerTypeMapping(srClass,dsr,BeanSerializerFactory.class, BeanDeserializerFactory.class);
  QName dsrcp = new QName("","DBServerCallParams");
  Class dsrcpClass= _doSQLRequest_DBServerCallParams.class;
  call.registerTypeMapping(dsrcpClass,dsrcp,BeanSerializerFactory.class, BeanDeserializerFactory.class);




  QName servQN = new QName("http://n-topus.com/DBS","UpdateCountService");
  QName portQN = new QName("http://n-topus.com/DBS","UpdateCountPort");
  Service service = new Service( new URL("file:updateCount.wsdl"), servQN );
  Call call = (Call) service.createCall( portQN, "GetUpdateCount" );
  opts.setDefaultURL( call.getTargetEndpointAddress() );
  call.setTargetEndpointAddress( new URL(opts.getURL()) );
  call.setUsername( opts.getUser() );
  call.setPassword( opts.getPassword() );  // basic authentication

  dbcp = new _doSQLRequest_DBServerCallParams();
  dbcp.setDbParam(args);
  request = new _doSQLRequest();
  request.setDBServerCallParams(dbcp);

  Object result = call.invoke( new Object[] { request } );

  System.out.println("invoke came back");
  }catch(Exception ex){ex.printStackTrace();}
}
}
/*
        Options opts = new Options(args);
        service = new Service();
        call = (Call) service.createCall();
        call.setTargetEndpointAddress( new URL(opts.getURL()) );
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("http://www.soapinterop.org/Bid");

        // register the PurchaseOrder class
        QName poqn = new QName("http://www.soapinterop.org/Bid",
                               "PurchaseOrder");
        Class cls = PurchaseOrder.class;
        call.registerTypeMapping(cls, poqn, BeanSerializerFactory.class, BeanDeserializerFactory.class);

*/
