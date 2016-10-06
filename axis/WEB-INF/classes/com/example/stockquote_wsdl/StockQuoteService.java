/**
 * StockQuoteService.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.example.stockquote_wsdl;

public interface StockQuoteService extends javax.xml.rpc.Service {

    // My first service
    public java.lang.String getStockQuotePortAddress();

    public com.example.stockquote_wsdl.StockQuotePortType getStockQuotePort() throws javax.xml.rpc.ServiceException;

    public com.example.stockquote_wsdl.StockQuotePortType getStockQuotePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException;
}
