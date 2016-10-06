var alph="ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/";
var indexOb=makeIndexObject(alph);
function makeIndexObject(S){
  var ob=new Object();
  if(S==null)return ob;
  for(var i=0;i<S.length;i++)ob[S.charAt(i)]=i;
  return ob;
}


function StringProducer(S){
  this.S=S;
  this.loc=0;
}
function sp_get(N){
  var res="";
  if(this.loc >= this.S.length) return res;
  var getEnd=this.loc+N;
  if(getEnd >= this.S.length){getEnd=this.S.length;}
  res=this.S.substring(this.loc,getEnd);
  this.loc=getEnd;
  return res;
}
StringProducer.prototype.get=sp_get;

function stringToBits(S,bits){
 var res="";
 for(var i=0;i<S.length;i++)res+=intToBits(indexOb[S.charAt(i)],bits);
 return res;
}
function intToBits(N,bits){
  var res="";
  for(var i=bits-1;i>=0;i--)res+=(1 & N>>i);
  return res;
}

function intFromBits(S){
  var res=0; 
  for(var i=0;i<S.length;i++)res=2*res+(S.charAt(i)=="1"?1:0);
  return res;
}
function htmlEncode(chars){
 var res="";
 for(var i=0;i<chars.length;i++){
  var c=chars.charAt(i);
  if(c=="<")res+="&lt;";
  else if(c==">")res+="&gt;";
  else if(c=="'")res+="&apos;";
  else if(c=='"')res+="&quot;";
  else res+=c;
  }
 return res;
}
function b64Decode(S){ // assumes S.length%4==0
  var SP=new StringProducer(S);
  var chars="";
  for(var r=SP.get(4);r.length>0;r=SP.get(4)){
    var bsp=new StringProducer(stringToBits(r,6));
    for(var ob=bsp.get(8);ob.length>0;ob=bsp.get(8))
      chars+=String.fromCharCode(intFromBits(ob));
    }
  return chars;
}

