// mode= books, music, dvd, electronics

function AmazonActorSearchRequestEnvelope(token,actor,mode){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:ActorSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <ActorSearchRequest xsi:type='namesp1:ActorRequest'>";
  S+="        <actor >"+actor+"</actor>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </ActorSearchRequest>";
  S+="    </namesp1:ActorSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonActorSearch(token,actor,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "ActorSearchRequest",
                  AmazonActorSearchRequestEnvelope(token,actor,mode));
}
function AmazonArtistSearchRequestEnvelope(token,artist,mode){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:ArtistSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <ArtistSearchRequest xsi:type='namesp1:ArtistRequest'>";
  S+="        <artist >"+artist+"</artist>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </ArtistSearchRequest>";
  S+="    </namesp1:ArtistSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonArtistSearch(token,artist,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "ArtistSearchRequest",
                  AmazonArtistSearchRequestEnvelope(token,artist,mode));
}

function AmazonAsinSearchRequestEnvelope(token,asin,mode){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:AsinSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <AsinSearchRequest xsi:type='namesp1:AsinRequest'>";
  S+="        <asin >"+asin+"</asin>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </AsinSearchRequest>";
  S+="    </namesp1:AsinSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonAsinSearch(token,asin,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "AsinSearchRequest",
                  AmazonAsinSearchRequestEnvelope(token,asin,mode));
}

function AmazonAuthorSearchRequestEnvelope(token,author,mode){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:AuthorSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <AuthorSearchRequest xsi:type='namesp1:AuthorRequest'>";
  S+="        <author >"+author+"</author>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </AuthorSearchRequest>";
  S+="    </namesp1:AuthorSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonAuthorSearch(token,author,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "AuthorSearchRequest",
                  AmazonAuthorSearchRequestEnvelope(token,author,mode));
}

function AmazonBrowseNodeSearchRequestEnvelope(token,browsenode,mode){ // browsenode=1000
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:BrowseNodeSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <BrowseNodeSearchRequest xsi:type='namesp1:ArtistRequest'>";
  S+="        <browse_node >"+browsenode+"</browse_node>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </BrowseNodeSearchRequest>";
  S+="    </namesp1:BrowseNodeSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonBrowseNodeSearch(token,browsenode,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "BrowseNodeSearchRequest",
                  AmazonBrowseNodeSearchRequestEnvelope(token,browsenode,mode));
}

function AmazonDirectorSearchRequestEnvelope(token,director,mode){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:DirectorSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <DirectorSearchRequest xsi:type='namesp1:DirectorRequest'>";
  S+="        <director >"+director+"</director>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </DirectorSearchRequest>";
  S+="    </namesp1:DirectorSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonDirectorSearch(token,director,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "DirectorSearchRequest",
                  AmazonDirectorSearchRequestEnvelope(token,director,mode));
}

function AmazonExchangeSearchRequestEnvelope(token,exchangeId){ // exchangeId=Y01Y2741473Y6491313
  var S="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <m:ExchangeSearchRequest xmlns:m='urn:PI/DevCentral/SoapService'>";
  S+="      <ExchangeSearchRequest xsi:type='m:ExchangeRequest'>";
  S+="        <exchange_id xsi:type='xsd:string'>"+exchangeId+"</exchange_id>";
  S+="        <tag xsi:type='xsd:string'>webservices-20</tag>";
  S+="        <type xsi:type='xsd:string'>lite</type>";
  S+="        <devtag xsi:type='xsd:string'>"+token+"</devtag>";
  S+="      </ExchangeSearchRequest>";
  S+="    </m:ExchangeSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonExchangeSearch(token,exchangeId){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "ExchangeSearchRequest",
                  AmazonExchangeSearchRequestEnvelope(token,exchangeId));
}

function AmazonKeywordSearchRequestEnvelope(token,keyword,mode){
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:KeywordSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <KeywordSearchRequest xsi:type='namesp1:KeywordRequest'>";
  S+="        <keyword >"+keyword+"</keyword>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </KeywordSearchRequest>";
  S+="    </namesp1:KeywordSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}

function doAmazonKeywordSearch(token,keyword,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "KeywordSearchRequest",
                  AmazonKeywordSearchRequestEnvelope(token,keyword,mode));
}

function AmazonListManiaSearchRequestEnvelope(token, lmID){ // lmId=34TRCFE5HC23
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:ListManiaSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <ListManiaSearchRequest xsi:type='namesp1:KeywordRequest'>";
  S+="        <lm_id >"+lmID+"</lm_id>";
  S+="        <page >1</page>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </ListManiaSearchRequest>";
  S+="    </namesp1:ListManiaSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonListManiaSearch(token,lmId,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "ListManiaSearchRequest",
                  AmazonListManiaSearchRequestEnvelope(token,lmId,mode));
}

function AmazonManufacturerSearchRequestEnvelope(token,manufacturer,mode){ // manufacturer="palm"
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:ManufacturerSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <ManufacturerSearchRequest xsi:type='namesp1:ManufacturerRequest'>";
  S+="        <manufacturer >"+manufacturer+"</manufacturer>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </ManufacturerSearchRequest>";
  S+="    </namesp1:ManufacturerSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonManufacturerSearch(token,manufacturer,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "ManufacturerSearchRequest",
                  AmazonManufacturerSearchRequestEnvelope(token,manufacturer,mode));
}

function AmazonPowerSearchRequestEnvelope(token,request,mode){//request=pubdate:2002 and author:Knuth
  var S="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <m:PowerSearchRequest xmlns:m='urn:PI/DevCentral/SoapService'>";
  S+="      <PowerSearchRequest xsi:type='m:PowerRequest'>";
  S+="        <power xsi:type='xsd:string'>"+request+"</power>";
  S+="        <mode xsi:type='xsd:string'>"+mode+"</mode>";
  S+="        <tag xsi:type='xsd:string'>webservices-20</tag>";
  S+="        <type xsi:type='xsd:string'>lite</type>";
  S+="        <devtag xsi:type='xsd:string'>"+token+"</devtag>";
  S+="      </PowerSearchRequest>";
  S+="    </m:PowerSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonPowerSearch(token,request,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "PowerSearchRequest",
                  AmazonPowerSearchRequestEnvelope(token,request,mode));
}

function AmazonSellerProfileSearchRequestEnvelope(token,sellerId){//sellerId=ARZ6W4AEZ5FQH
  var S="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <m:SellerProfileSearchRequest xmlns:m='urn:PI/DevCentral/SoapService'>";
  S+="      <SellerProfileSearchRequest xsi:type='m:SellerProfileRequest'>";
  S+="        <seller_id xsi:type='xsd:string'>"+sellerId+"</seller_id>";
  S+="        <tag xsi:type='xsd:string'>webservices-20</tag>";
  S+="        <type xsi:type='xsd:string'>lite</type>";
  S+="        <devtag xsi:type='xsd:string'>"+token+"</devtag>";
  S+="        <page xsi:type='xsd:string'>1</page>";
  S+="      </SellerProfileSearchRequest>";
  S+="    </m:SellerProfileSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonSellerProfileSearch(token,sellerId){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "SellerProfileSearchRequest",
                  AmazonSellerProfileSearchRequestEnvelope(token,sellerId));
}

function AmazonSellerSearchRequestEnvelope(token,sellerId){//sellerId=ARZ6W4AEZ5FQH
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <m:SellerSearchRequest xmlns:m='urn:PI/DevCentral/SoapService'>";
  S+="      <SellerSearchRequest xsi:type='m:SellerRequest'>";
  S+="        <seller_id xsi:type='xsd:string'>"+sellerId+"</seller_id>";
  S+="        <tag xsi:type='xsd:string'>webservices-20</tag>";
  S+="        <type xsi:type='xsd:string'>lite</type>";
  S+="        <devtag xsi:type='xsd:string'>"+token+"</devtag>";
  S+="        <offerstatus xsi:type='xsd:string'>closed</offerstatus>";
  S+="        <page xsi:type='xsd:string'>1</page>";
  S+="      </SellerSearchRequest>";
  S+="    </m:SellerSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonSellerSearch(token,sellerId){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "SellerSearchRequest",
                  AmazonSellerSearchRequestEnvelope(token,sellerId));
}

function AmazonSimilaritySearchRequestEnvelope(token,asin,assocTag,mode){//asin=B000067RPH
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:SimilaritySearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <SimilaritySearchRequest xsi:type='namesp1:SimilarityRequest'>";
  S+="        <asin >"+asin+"</asin>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >"+assocTag+"</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </SimilaritySearchRequest>";
  S+="    </namesp1:SimilaritySearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";
  return S;
}
function doAmazonSimilaritySearch(token,asin,assocTag,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "SimilaritySearchRequest",
                  AmazonSimilaritySearchRequestEnvelope(token,asin,assocTag,mode));
}


function AmazonUpcSearchRequestEnvelope(token,upc,mode){//upc=044001774720
  var S="<?xml version='1.0' encoding='UTF-8'?>\n";
  S+="<SOAP-ENV:Envelope xmlns:SOAP-ENV='http://schemas.xmlsoap.org/soap/envelope/' xmlns:SOAP-ENC='http://schemas.xmlsoap.org/soap/encoding/' xmlns:xsi='http://www.w3.org/2001/XMLSchema-instance' xmlns:xsd='http://www.w3.org/2001/XMLSchema' SOAP-ENV:encodingStyle='http://schemas.xmlsoap.org/soap/encoding/'>";
  S+="  <SOAP-ENV:Body>";
  S+="    <namesp1:UpcSearchRequest xmlns:namesp1='urn:PI/DevCentral/SoapService'>";
  S+="      <UpcSearchRequest xsi:type='namesp1:UpcRequest'>";
  S+="        <upc >"+upc+"</upc>";
  S+="        <page >1</page>";
  S+="        <mode >"+mode+"</mode>";
  S+="        <tag >webservices-20</tag>";
  S+="        <type >lite</type>";
  S+="        <devtag >"+token+"</devtag>";
  S+="        <format >xml</format>";
  S+="        <version >1.0</version>";
  S+="      </UpcSearchRequest>";
  S+="    </namesp1:UpcSearchRequest>";
  S+="  </SOAP-ENV:Body>";
  S+="</SOAP-ENV:Envelope>";  
  return S;
}
function doAmazonUpcSearch(token,upc,mode){
  return doSoapCall("http://soap.amazon.com/onca/soap",
                    "UpcSearchRequest",
                  AmazonUpcSearchRequestEnvelope(token,upc,mode));
}

