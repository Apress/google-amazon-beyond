/*
 * Copyright 2002 Eric Hodel. All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions
 * are met:
 *
 * 1. Redistributions of source code must retain the above copyright
 *     notice, this list of conditions and the following disclaimer.
 * 2. Redistributions in binary form must reproduce the above copyright
 *    notice, this list of conditions and the following disclaimer in
 *    the documentation and/or other materials provided with the
 *    distribution.
 * 3. Neither the name of Eric Hodel nor the names of his
 *    contributors may be used to endorse or promote products derived
 *    from this software without specific prior written permission.
 *
 * THIS SOFTWARE IS PROVIDED BY ERIC HODEL AND CONTRIBUTORS ``AS IS''
 * AND ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED
 * TO, THE IMPLIED WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A
 * PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT SHALL ERIC HODEL OR
 * CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT, INCIDENTAL,
 * SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT
 * LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF
 * USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY,
 * OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT
 * OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF
 * SUCH DAMAGE.
 */

/*
 * GoogleAPI implements the Google SOAP APIs:
 * http://www.google.com/apis/
 *
 * To use the google API you will need to get a Google key, which is
 * available at the above URL.
 *
 * In order to use this class, you must either:
 *
 * Run it from a chrome:// URL
 * 
 * Run it from a file:// URL and call:
 *
 * netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead")
 *
 * before calling s.invoke().  
 *
 * afterwards to revoke this priviledge.
 *
 * Sign your scripts so they can be run from an http:// URL.
 *
 * --
 *
 * Thanks to Jesse Ruderman <jruderman@hmc.edu> for noticing I had 
 * SOAPParameter misspelled and was missing the maxResults param in
 * search()
 *
 */
function GoogleAPI (googleKey) {
  if (googleKey) {
    this.init(googleKey);
  }
}

GoogleAPI.prototype = {
  init : function(googleKey) {
    this.googleKey = googleKey;
  },

  /*
   * Spell check a phrase
   */
  spellcheck : function(phrase) {
    var checkedPhrase = "";
    var phraseArray = phrase.split(" ");

    /*
     * The spell check will only check 10 words at a time, and 2048 bytes
     * max, so we split up the phrase into chunks and send them
     * one at a time.
     */
    for (var i = 0; i < phraseArray.length; i += 10) {
      /* XXX: need to ensure we aren't over 2048 bytes */
      var phraseChunk = phraseArray.slice(i, i + 10).join(" ");

      var s = new SOAPCall();

      if(s) {
        var soapversion = 0;  //  Version 1.1
        var method = "doSpellingSuggestion";
        var object = "urn:GoogleSearch";
        var headers = [];
        var params = [
          new SOAPParameter(this.googleKey, "key"),
          new SOAPParameter(phraseChunk, "p")
        ];

        s.encode(soapversion, method, object, headers.length, headers,
          params.length, params);
        s.transportURI = "http://api.google.com/search/beta2"

        netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");
        var response = s.invoke();
        if (response.fault == null) {
          var result = response.message.getElementsByTagName("return")[0].firstChild;
          if (result) {
            checkedPhrase += result.nodeValue + " ";
          } else {
            checkedPhrase += phraseChunk + " "; /* no spelling errors */
          }

        } else {
          /* something failed with the soap call, end */
          return null;
        }
      } else {
        /* soap call creation failed, end */
        return null;
      } 
    }

    return checkedPhrase;
  },

  /*
   * Perform a google search
   *
   * Parameters:
   * q - query string
   * start - zero-based index of the first desired result
   * maxResults - number of results desired, starting at start
   * filter - hide similar results
   * restrict - restrict to a particular language or topic
   *            see API reference for more details
   * safeSearch - exclude adult content when true
   * lr - restrict to certain languages
   *
   * Return value:
   * On success, search will return the complete SOAP response message
   *
   * If creation of the SOAP call fails, a string will be returned
   * saying as much
   *
   * If there is an error processing the response, an object will be 
   * returned containing the fault and a message string.
   *
   */
  search : function (q, start, maxResults, filter, restrict, safeSearch, lr) {
    var s = new SOAPCall();

    if (!s)
      return "Error creating SOAPCall object";

    var soapversion = 0;
    var method = "doGoogleSearch";
    var object = "urn:GoogleSearch";
    var headers = [];
    var params = [
      new SOAPParameter(this.googleKey, "key"),
      new SOAPParameter(q, "q"),
      new SOAPParameter(start, "start"),
      new SOAPParameter(maxResults, "maxResults"),
      new SOAPParameter(filter, "filter"),
      new SOAPParameter(restrict, "restrict"),
      new SOAPParameter(safeSearch, "safeSearch"),
      new SOAPParameter(lr, "lr"),
      new SOAPParameter("utf8", "ie"),
      new SOAPParameter("utf8", "oe")
    ];

    s.encode(soapversion, method, object, headers.length, headers,
      params.length, params);
    s.transportURI = "http://api.google.com/search/beta2"
alert("about to do privilege");
    netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");
alert("got privilege");
    var response = s.invoke();

    if (response.fault)
      return { msg : "SOAP call error", fault : response.fault };

    return response.message;
  },

  /*
   * Retrieve a url from Google's cache
   */
  getCachedPage : function (url) {
    var s = new SOAPCall();

    if (s) {
      var soapversion = 0;
      var method = "doGetCachedPage";
      var object = "urn:GoogleSearch";
      var headers = [];
      var params = [
        new SOAPParameter(this.googleKey, "key"),
        new SOAPParameter(url, "url")
      ];

      s.encode(soapversion, method, object, headers.length, headers,
        params.length, params);
      s.transportURI = "http://api.google.com/search/beta2"

      netscape.security.PrivilegeManager.enablePrivilege("UniversalBrowserRead");
      var response = s.invoke();
      if (response.fault == null) {
        return response.message.getElementsByTagName("return")[0].firstChild.nodeValue;
      }
    }

    return null;
  }
}
