var inIE=document.all != null;
var showCallResponse=true;
var showCallRequest=true;
/* weather report via http://www.capescience.com/webservices/globalweather/index.shtml */
function doGetWeatherReportEnvelope(code){
  var S='<?xml version="1.0" encoding="UTF-8"?>\n';
  S+='<SOAP-ENV:Envelope';
  S+='    SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"';
  S+='    xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/"';
  S+='    xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"';
  S+='    xmlns:ns0="capeconnect:GlobalWeather:GlobalWeather"';
  S+='    xmlns:xsd="http://www.w3.org/2001/XMLSchema"';
  S+='    xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance">';
  S+='    <SOAP-ENV:Body>';
  S+='        <ns0:getWeatherReport>';
  S+='            <code xsi:type="xsd:string">' +code+ '</code>';
  S+='        </ns0:getWeatherReport>';
  S+='    </SOAP-ENV:Body>';
  S+='</SOAP-ENV:Envelope>';  
  return S;
}

function doGetWeatherReport(code){
  alert("dogetweatherreport("+code+")");
  return doSoapCall("http://live.capescience.com/ccx/GlobalWeather",
                    "capeconnect:GlobalWeather:GlobalWeather#getWeatherReport",
                  doGetWeatherReportEnvelope(code));
}
function doAmazonKeywordSearchEnvelope(token,keyword){
  var S='<?xml version="1.0" encoding="UTF-8"?>\n';
  S+='<SOAP-ENV:Envelope';
  S+='   xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"';
  S+='   xmlns:SOAP-ENC="http://schemas.xmlsoap.org/soap/encoding/"';
  S+='   xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"';
  S+='   xmlns:xsd="http://www.w3.org/2001/XMLSchema"';
  S+='   SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">';
  S+='  <SOAP-ENV:Body>';
  S+='    <namesp1:KeywordSearchRequest xmlns:namesp1="urn:PI/DevCentral/SoapService">';
  S+='      <KeywordSearchRequest xsi:type="namesp1:KeywordRequest">';
  S+='        <keyword >'+keyword+'</keyword>';
  S+='        <page >1</page>';
  S+='        <mode >books</mode>';
  S+='        <tag >webservices-20</tag>';
  S+='        <type >lite</type>';
  S+='        <devtag >'+token+'</devtag>';
  S+='        <format >xml</format>';
  S+='        <version >1.0</version>';
  S+='      </KeywordSearchRequest>';
  S+='    </namesp1:KeywordSearchRequest>';
  S+='  </SOAP-ENV:Body>';
  S+='</SOAP-ENV:Envelope>';
  return S;
}
function doAmazonKeywordSearch(token,keyword){
  alert("doAmazonKeywordSearch("+keyword+")");
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "KeywordSearchRequest",
                  doAmazonKeywordSearchEnvelope(token,keyword));
}
function doSoapCall(uri,soapAction,env){
alert("doSoapCall");
  try{
    var xmlDoc=parseXML(env);
    if(showCallRequest)
      with(parent.callFrame)
        {document.write(xml2HtmlPage(xmlDoc)); document.close();}
    var xmlhttp=null; var doc=null;
    if(inIE) xmlhttp=new ActiveXObject('MSXML2.XMLHTTP');
    else xmlhttp=new XMLHttpRequest();
    if(!xmlhttp)
      return alert("doSoapCall("+soapAction+"): can't initialize xmlhttp object");
    if(!inIE)
      netscape.security.PrivilegeManager.
        enablePrivilege("UniversalBrowserRead");
    xmlhttp.open('POST',uri,false);
    xmlhttp.setRequestHeader("SOAPAction", soapAction)
    xmlhttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8")
    xmlhttp.send(env);
    var result=xmlhttp.responseXML;
    if(showCallResponse)
      with(parent.responseFrame)
        {document.write(xml2HtmlPage(result));document.close();}
    return xmlhttp.responseXML;
  }catch(ex){alert("doSoapCall("+soapAction+") error: "+ex);}
  return null;
}

/*  end weather report */
function doGetCachedPageEnvelope(key,url){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+='<SOAP-ENV:Envelope';
  S+=' xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"';
  S+=' xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance"';
  S+=' xmlns:xsd="http://www.w3.org/1999/XMLSchema">';
  S+='  <SOAP-ENV:Body>';
  S+='  <ns1:doGetCachedPage xmlns:ns1="urn:GoogleSearch" ';
  S+='   SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">';
  S+='   <key xsi:type="xsd:string">' +key+ '</key>';
  S+='   <url xsi:type="xsd:string">' +url+ '</url>';
  S+='  </ns1:doGetCachedPage>';
  S+=' </SOAP-ENV:Body>';
  S+='</SOAP-ENV:Envelope>';
  return S;
}

function parseXML(str){
  if(inIE){
    var doc=new ActiveXObject("Microsoft.XMLDOM");
    doc.loadXML(str);
    return doc; // .documentElement;
  }
  return (new DOMParser()).parseFromString(str, "text/xml");
}

function doGetCachedPage(key,url){
  return doGoogle("doGetCachedPage",
                  doGetCachedPageEnvelope(key,url));
}
function doGoogle(method,env){
  try{
    var xmlDoc=parseXML(env);
    if(showCallRequest)
      with(parent.callFrame)
        {document.write(xml2HtmlPage(xmlDoc)); document.close();}
    var xmlhttp=null; var doc=null;
    if(inIE) xmlhttp=new ActiveXObject('MSXML2.XMLHTTP');
    else xmlhttp=new XMLHttpRequest();
    if(!xmlhttp)
      return alert("doGoogle("+method+"): can't initialize xmlhttp object");
    if(!inIE)
      netscape.security.PrivilegeManager.
        enablePrivilege("UniversalBrowserRead");
    xmlhttp.open('POST',"http://api.google.com/search/beta2",false);
    xmlhttp.setRequestHeader("SOAPAction", method)
    xmlhttp.setRequestHeader("Content-Type", "text/xml; charset=utf-8")
    xmlhttp.send(env);
    var result=xmlhttp.responseXML;
    if(showCallResponse)
      with(parent.responseFrame)
        {document.write(xml2HtmlPage(result));document.close();}
    return xmlhttp.responseXML;
  }catch(ex){alert("doGoogle("+method+") error: "+ex);}
  return null;
}

function doSpellingSuggestionEnvelope(key,phrase){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+='<SOAP-ENV:Envelope';
  S+=' xmlns:SOAP-ENV="http://schemas.xmlsoap.org/soap/envelope/"';
  S+=' xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance"';
  S+=' xmlns:xsd="http://www.w3.org/1999/XMLSchema">';
  S+=' <SOAP-ENV:Body>';
  S+='  <ns1:doSpellingSuggestion xmlns:ns1="urn:GoogleSearch"';
  S+='   SOAP-ENV:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/">';
  S+='   <key xsi:type="xsd:string">' +key+ '</key>';
  S+='   <phrase xsi:type="xsd:string">' +phrase+ '</phrase>';
  S+='  </ns1:doSpellingSuggestion>';
  S+=' </SOAP-ENV:Body>';
  S+='</SOAP-ENV:Envelope>';
  return S;
}
function doSpellingSuggestion(key,phrase){ 
  return doGoogle("doSpellingSuggestion",
                  doSpellingSuggestionEnvelope(key,phrase));
}

function doGoogleSearchEnvelope(key,q,start,maxResults){
  var env='<?xml version="1.0" encoding="UTF-8"?>\n';
  env+='<env:Envelope xmlns:env="http://schemas.xmlsoap.org/soap/envelope/"';
  env+='  xmlns:enc="http://schemas.xmlsoap.org/soap/encoding/"';
  env+='  env:encodingStyle="http://schemas.xmlsoap.org/soap/encoding/"';
  env+='  xmlns:xs="http://www.w3.org/1999/XMLSchema"';
  env+='  xmlns:xsi="http://www.w3.org/1999/XMLSchema-instance">';
//   env+=' <env:Header/>';
  env+=' <env:Body>';
  env+='  <a0:doGoogleSearch xmlns:a0="urn:GoogleSearch">';
  env+='   <key xsi:type="xs:string">'+key+'</key>';
  env+='   <q xsi:type="xs:string">'+q+'</q>';
  env+='   <start xsi:type="xs:int">'+start+'</start>';
  env+='   <maxResults xsi:type="xs:int">'+maxResults+'</maxResults>';
  env+='   <filter xsi:type="xs:boolean">1</filter>';
  env+='   <restrict xsi:type="xs:string"/>';
  env+='   <safeSearch xsi:type="xs:boolean">0</safeSearch>';
  env+='   <lr xsi:type="xs:string"/>';
  env+='   <ie xsi:type="xs:string">utf8</ie>';
  env+='   <oe xsi:type="xs:string">utf8</oe>';
  env+='  </a0:doGoogleSearch>';
  env+=' </env:Body>';
  env+='</env:Envelope>';
  return env;
}

function doGoogleSearch(key,q,start,maxResults){ 
  return doGoogle("doGoogleSearch",
                  doGoogleSearchEnvelope(key,q,start,maxResults));
}

function toXML(x){
  if(inIE)return x.xml;
  return xml2xml(x);
/*
  if(!toXML.serializer)toXML.serializer=new XMLSerializer();
  return toXML.serializer.serializeToString(x);
*/
}
  
var xml2HtmlStyle="margin-left:5;font-size:"+(inIE?12:8);
var xml2HtmlStyleDiv="<div style='"+xml2HtmlStyle+"'>";

/**
  * xml2Html(node) trivially transforms an XML node into an XHTML
  *  representation with reasonable indentation. See
  * http://www.w3.org/TR/2000/REC-DOM-Level-2-Core-20001113/java-binding.html
  * for nodeTypes, e.g. 1==Element, 7=Processing Instruction, 3=Text
**/
function xml2Html(node){
  if(null==node)return "";
  if(node.nodeType == 3)  // a text node
    return node.nodeValue;
  var name=node.nodeName;
  var S=xml2HtmlStyleDiv; 
  if(node.nodeType == 7) // a processing instruction
    return S+xmlPInode2Html(node)+"</div>";
  if(node.nodeType == 9) // a top-level document.
    return S+xml2HtmlNodeChildren(node)+"</div>";

  S+="&lt;"+node.nodeName+xmlAttrs2Html(node.attributes)+"&gt;";
  S+=xml2HtmlNodeChildren(node);  // recursion here
  S+="&lt;/"+node.nodeName+"&gt;</div>";
  return S;
}
function toText(node){
  if(null==node)return "";
  if(node.nodeType == 3) return xmlEncode(node.nodeValue)+"\n";
  var S="";
  for(var C=node.firstChild;null!=C;C=C.nextSibling)S+=toText(C);
  return S;
}
function xmlEncode(S){
 if(!S)return S;
 if(S.indexOf('<')>=0)S=S.split('<').join('&lt;');
 if(S.indexOf('&')>=0)S=S.split('&').join('&amp;');
 return S;
}
function xml2HtmlNodeChildren(node){
  var S="";
  for(var C=node.firstChild;null!=C;C=C.nextSibling)S+=xml2Html(C);
  return S;
}
function xmlPInode2Html(node){ // node.nodeType==7, PI node
  var S="&lt;?"+node.nodeName+xmlAttrs2Html(node.attributes)+"?&gt;";
  return S;
}
function xml2HtmlPage(node){ // top-level page output for an xml node
  var S="<html><head><title>Generated Page</title></head><body>";
  S+=xml2Html(node);
  S+="</body></h"+"tml>";
  return S;
}

function xmlAttrs2Html(atts){
  var S="";
  if(atts!=null)
    for(var i=0;i<atts.length;i++)
      S+=" "+atts[i].name+"='"+atts[i].value+"'";
  return S;
}


function xml2xml(node){
  if(null==node)return "";
  if(node.nodeType == 3)  // a text node
    return xmlEncode(node.nodeValue);
  if(node.nodeType == 7) // a processing instruction
    return xmlPInode2xml(node);
  if(node.nodeType == 9) // a top-level document.
    return "<root>"+xml2xmlNodeChildren(node)+"</root>\n";
  var S="<"+node.nodeName+xmlAttrs2Html(node.attributes)+">";
  S+=xml2xmlNodeChildren(node);  // recursion here
  S+="</"+node.nodeName+">\n";
  return S;
}
function xml2xmlNodeChildren(node){
  var S="";
  for(var C=node.firstChild;null!=C;C=C.nextSibling)S+=xml2xml(C);
  return S;
}
function xmlPInode2xml(node){ // node.nodeType==7, PI node
  var S="<?"+node.nodeName+xmlAttrs2Html(node.attributes)+"?>";
  return S;
}

function displayXML(doc,targetFrame) {
  with(targetFrame) {
    document.write(xml2HtmlPage(doc));
    document.close();
  }
}
