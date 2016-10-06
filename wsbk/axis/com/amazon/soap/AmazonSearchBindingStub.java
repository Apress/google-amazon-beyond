/**
 * AmazonSearchBindingStub.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis WSDL2Java emitter.
 */

package com.amazon.soap;

public class AmazonSearchBindingStub extends org.apache.axis.client.Stub implements com.amazon.soap.AmazonSearchPort {
    private java.util.Vector cachedSerClasses = new java.util.Vector();
    private java.util.Vector cachedSerQNames = new java.util.Vector();
    private java.util.Vector cachedSerFactories = new java.util.Vector();
    private java.util.Vector cachedDeserFactories = new java.util.Vector();

    static org.apache.axis.description.OperationDesc [] _operations;

    static {
        _operations = new org.apache.axis.description.OperationDesc[23];
        org.apache.axis.description.OperationDesc oper;
        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("KeywordSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "KeywordSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "KeywordRequest"), com.amazon.soap.KeywordRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[0] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("PowerSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "PowerSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "PowerRequest"), com.amazon.soap.PowerRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[1] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BrowseNodeSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "BrowseNodeSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "BrowseNodeRequest"), com.amazon.soap.BrowseNodeRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[2] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AsinSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "AsinSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "AsinRequest"), com.amazon.soap.AsinRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[3] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("BlendedSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "BlendedSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "BlendedRequest"), com.amazon.soap.BlendedRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductLineArray"));
        oper.setReturnClass(com.amazon.soap.ProductLine[].class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[4] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("UpcSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "UpcSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "UpcRequest"), com.amazon.soap.UpcRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[5] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AuthorSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "AuthorSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "AuthorRequest"), com.amazon.soap.AuthorRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[6] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ArtistSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ArtistSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ArtistRequest"), com.amazon.soap.ArtistRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[7] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ActorSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ActorSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ActorRequest"), com.amazon.soap.ActorRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[8] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ManufacturerSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ManufacturerSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ManufacturerRequest"), com.amazon.soap.ManufacturerRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[9] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("DirectorSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "DirectorSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "DirectorRequest"), com.amazon.soap.DirectorRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[10] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ExchangeSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ExchangeSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ExchangeRequest"), com.amazon.soap.ExchangeRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ListingProductDetails"));
        oper.setReturnClass(com.amazon.soap.ListingProductDetails.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[11] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ListManiaSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ListManiaSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ListManiaRequest"), com.amazon.soap.ListManiaRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[12] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("WishlistSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "WishlistSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "WishlistRequest"), com.amazon.soap.WishlistRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[13] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SellerProfileSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "SellerProfileSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfileRequest"), com.amazon.soap.SellerProfileRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfile"));
        oper.setReturnClass(com.amazon.soap.SellerProfile.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[14] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SellerSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "SellerSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "SellerRequest"), com.amazon.soap.SellerRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "SellerSearch"));
        oper.setReturnClass(com.amazon.soap.SellerSearch.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[15] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("MarketplaceSearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "MarketplaceSearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceRequest"), com.amazon.soap.MarketplaceRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceSearch"));
        oper.setReturnClass(com.amazon.soap.MarketplaceSearch.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[16] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("SimilaritySearchRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "SimilaritySearchRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "SimilarityRequest"), com.amazon.soap.SimilarityRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo"));
        oper.setReturnClass(com.amazon.soap.ProductInfo.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "return"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[17] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("GetShoppingCartRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "GetShoppingCartRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "GetShoppingCartRequest"), com.amazon.soap.GetShoppingCartRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ShoppingCart"));
        oper.setReturnClass(com.amazon.soap.ShoppingCart.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ShoppingCart"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[18] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ClearShoppingCartRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ClearShoppingCartRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ClearShoppingCartRequest"), com.amazon.soap.ClearShoppingCartRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ShoppingCart"));
        oper.setReturnClass(com.amazon.soap.ShoppingCart.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ShoppingCart"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[19] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("AddShoppingCartItemsRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "AddShoppingCartItemsRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "AddShoppingCartItemsRequest"), com.amazon.soap.AddShoppingCartItemsRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ShoppingCart"));
        oper.setReturnClass(com.amazon.soap.ShoppingCart.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ShoppingCart"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[20] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("RemoveShoppingCartItemsRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "RemoveShoppingCartItemsRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "RemoveShoppingCartItemsRequest"), com.amazon.soap.RemoveShoppingCartItemsRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ShoppingCart"));
        oper.setReturnClass(com.amazon.soap.ShoppingCart.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ShoppingCart"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[21] = oper;

        oper = new org.apache.axis.description.OperationDesc();
        oper.setName("ModifyShoppingCartItemsRequest");
        oper.addParameter(new javax.xml.namespace.QName("", "ModifyShoppingCartItemsRequest"), new javax.xml.namespace.QName("http://soap.amazon.com", "ModifyShoppingCartItemsRequest"), com.amazon.soap.ModifyShoppingCartItemsRequest.class, org.apache.axis.description.ParameterDesc.IN, false, false);
        oper.setReturnType(new javax.xml.namespace.QName("http://soap.amazon.com", "ShoppingCart"));
        oper.setReturnClass(com.amazon.soap.ShoppingCart.class);
        oper.setReturnQName(new javax.xml.namespace.QName("", "ShoppingCart"));
        oper.setStyle(org.apache.axis.enum.Style.RPC);
        oper.setUse(org.apache.axis.enum.Use.ENCODED);
        _operations[22] = oper;

    }

    public AmazonSearchBindingStub() throws org.apache.axis.AxisFault {
         this(null);
    }

    public AmazonSearchBindingStub(java.net.URL endpointURL, javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
         this(service);
         super.cachedEndpoint = endpointURL;
    }

    public AmazonSearchBindingStub(javax.xml.rpc.Service service) throws org.apache.axis.AxisFault {
        if (service == null) {
            super.service = new org.apache.axis.client.Service();
        } else {
            super.service = service;
        }
            java.lang.Class cls;
            javax.xml.namespace.QName qName;
            java.lang.Class beansf = org.apache.axis.encoding.ser.BeanSerializerFactory.class;
            java.lang.Class beandf = org.apache.axis.encoding.ser.BeanDeserializerFactory.class;
            java.lang.Class enumsf = org.apache.axis.encoding.ser.EnumSerializerFactory.class;
            java.lang.Class enumdf = org.apache.axis.encoding.ser.EnumDeserializerFactory.class;
            java.lang.Class arraysf = org.apache.axis.encoding.ser.ArraySerializerFactory.class;
            java.lang.Class arraydf = org.apache.axis.encoding.ser.ArrayDeserializerFactory.class;
            java.lang.Class simplesf = org.apache.axis.encoding.ser.SimpleSerializerFactory.class;
            java.lang.Class simpledf = org.apache.axis.encoding.ser.SimpleDeserializerFactory.class;
            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfile");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerProfile.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "RemoveShoppingCartItemsRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.RemoveShoppingCartItemsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ListingProductDetailsArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ListingProductDetails[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SimilarProductsArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "Item");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Item.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AuthorArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "CustomerReview");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.CustomerReview.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "UpcRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.UpcRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerSearchDetailsArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerSearchDetails[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ProductLine");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ProductLine.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "KeywordRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.KeywordRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfileRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerProfileRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ThirdPartyProductDetailsArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ThirdPartyProductDetails[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AuthorRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.AuthorRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ShoppingCart");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ShoppingCart.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerFeedback");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerFeedback.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ListingProductDetails");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ListingProductDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ItemQuantity");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ItemQuantity.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ItemArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Item[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceSearchDetailsArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.MarketplaceSearchDetails[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ThirdPartyProductInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ThirdPartyProductInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ThirdPartyProductDetails");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ThirdPartyProductDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.MarketplaceRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "KeyPhrase");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.KeyPhrase.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "BrowseNode");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.BrowseNode.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AddItemArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.AddItem[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SimilarityRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SimilarityRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ModifyShoppingCartItemsRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ModifyShoppingCartItemsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceSearchDetails");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.MarketplaceSearchDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "PlatformArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ItemQuantityArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ItemQuantity[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "WishlistRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.WishlistRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AddItem");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.AddItem.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AddShoppingCartItemsRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.AddShoppingCartItemsRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ActorRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ActorRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AsinRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.AsinRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "FeedbackArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Feedback[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ProductLineArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ProductLine[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "Reviews");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Reviews.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "Track");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Track.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ListArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ExchangeRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ExchangeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "GetShoppingCartRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.GetShoppingCartRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "DirectorRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.DirectorRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "BlendedRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.BlendedRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "DirectorArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ProductInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ProductInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ListManiaRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ListManiaRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "BrowseNodeRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.BrowseNodeRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ArtistRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ArtistRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ItemIdArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceSearch");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.MarketplaceSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfileDetails");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerProfileDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerSearch");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerSearch.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ArtistArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ManufacturerRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ManufacturerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerSearchDetails");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerSearchDetails.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "AccessoryArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "BrowseNodeArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.BrowseNode[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "CustomerReviewArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.CustomerReview[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "PowerRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.PowerRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ListingProductInfo");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ListingProductInfo.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "Details");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Details.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "DetailsArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Details[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "StarringArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "TrackArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Track[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "Feedback");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.Feedback.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "FeaturesArray");
            cachedSerQNames.add(qName);
            cls = java.lang.String[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "KeyPhraseArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.KeyPhrase[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfileDetailsArray");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.SellerProfileDetails[].class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(arraysf);
            cachedDeserFactories.add(arraydf);

            qName = new javax.xml.namespace.QName("http://soap.amazon.com", "ClearShoppingCartRequest");
            cachedSerQNames.add(qName);
            cls = com.amazon.soap.ClearShoppingCartRequest.class;
            cachedSerClasses.add(cls);
            cachedSerFactories.add(beansf);
            cachedDeserFactories.add(beandf);

    }

    private org.apache.axis.client.Call createCall() throws java.rmi.RemoteException {
        try {
            org.apache.axis.client.Call _call =
                    (org.apache.axis.client.Call) super.service.createCall();
            if (super.maintainSessionSet) {
                _call.setMaintainSession(super.maintainSession);
            }
            if (super.cachedUsername != null) {
                _call.setUsername(super.cachedUsername);
            }
            if (super.cachedPassword != null) {
                _call.setPassword(super.cachedPassword);
            }
            if (super.cachedEndpoint != null) {
                _call.setTargetEndpointAddress(super.cachedEndpoint);
            }
            if (super.cachedTimeout != null) {
                _call.setTimeout(super.cachedTimeout);
            }
            if (super.cachedPortName != null) {
                _call.setPortName(super.cachedPortName);
            }
            java.util.Enumeration keys = super.cachedProperties.keys();
            while (keys.hasMoreElements()) {
                java.lang.String key = (java.lang.String) keys.nextElement();
                _call.setProperty(key, super.cachedProperties.get(key));
            }
            // All the type mapping information is registered
            // when the first call is made.
            // The type mapping information is actually registered in
            // the TypeMappingRegistry of the service, which
            // is the reason why registration is only needed for the first call.
            synchronized (this) {
                if (firstCall()) {
                    // must set encoding style before registering serializers
                    _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
                    _call.setEncodingStyle(org.apache.axis.Constants.URI_SOAP11_ENC);
                    for (int i = 0; i < cachedSerFactories.size(); ++i) {
                        java.lang.Class cls = (java.lang.Class) cachedSerClasses.get(i);
                        javax.xml.namespace.QName qName =
                                (javax.xml.namespace.QName) cachedSerQNames.get(i);
                        java.lang.Class sf = (java.lang.Class)
                                 cachedSerFactories.get(i);
                        java.lang.Class df = (java.lang.Class)
                                 cachedDeserFactories.get(i);
                        _call.registerTypeMapping(cls, qName, sf, df, false);
                    }
                }
            }
            return _call;
        }
        catch (java.lang.Throwable t) {
            throw new org.apache.axis.AxisFault("Failure trying to get the Call object", t);
        }
    }

    public com.amazon.soap.ProductInfo keywordSearchRequest(com.amazon.soap.KeywordRequest keywordSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[0]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "KeywordSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {keywordSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo powerSearchRequest(com.amazon.soap.PowerRequest powerSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[1]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "PowerSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {powerSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo browseNodeSearchRequest(com.amazon.soap.BrowseNodeRequest browseNodeSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[2]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "BrowseNodeSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {browseNodeSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo asinSearchRequest(com.amazon.soap.AsinRequest asinSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[3]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "AsinSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {asinSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductLine[] blendedSearchRequest(com.amazon.soap.BlendedRequest blendedSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[4]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "BlendedSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {blendedSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductLine[]) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductLine[]) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductLine[].class);
            }
        }
    }

    public com.amazon.soap.ProductInfo upcSearchRequest(com.amazon.soap.UpcRequest upcSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[5]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "UpcSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {upcSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo authorSearchRequest(com.amazon.soap.AuthorRequest authorSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[6]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "AuthorSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {authorSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo artistSearchRequest(com.amazon.soap.ArtistRequest artistSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[7]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ArtistSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {artistSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo actorSearchRequest(com.amazon.soap.ActorRequest actorSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[8]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ActorSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {actorSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo manufacturerSearchRequest(com.amazon.soap.ManufacturerRequest manufacturerSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[9]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ManufacturerSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {manufacturerSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo directorSearchRequest(com.amazon.soap.DirectorRequest directorSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[10]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "DirectorSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {directorSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ListingProductDetails exchangeSearchRequest(com.amazon.soap.ExchangeRequest exchangeSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[11]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ExchangeSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {exchangeSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ListingProductDetails) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ListingProductDetails) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ListingProductDetails.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo listManiaSearchRequest(com.amazon.soap.ListManiaRequest listManiaSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[12]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ListManiaSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {listManiaSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo wishlistSearchRequest(com.amazon.soap.WishlistRequest wishlistSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[13]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "WishlistSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {wishlistSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.SellerProfile sellerProfileSearchRequest(com.amazon.soap.SellerProfileRequest sellerProfileSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[14]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "SellerProfileSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sellerProfileSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.SellerProfile) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.SellerProfile) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.SellerProfile.class);
            }
        }
    }

    public com.amazon.soap.SellerSearch sellerSearchRequest(com.amazon.soap.SellerRequest sellerSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[15]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "SellerSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {sellerSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.SellerSearch) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.SellerSearch) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.SellerSearch.class);
            }
        }
    }

    public com.amazon.soap.MarketplaceSearch marketplaceSearchRequest(com.amazon.soap.MarketplaceRequest marketplaceSearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[16]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "MarketplaceSearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {marketplaceSearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.MarketplaceSearch) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.MarketplaceSearch) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.MarketplaceSearch.class);
            }
        }
    }

    public com.amazon.soap.ProductInfo similaritySearchRequest(com.amazon.soap.SimilarityRequest similaritySearchRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[17]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "SimilaritySearchRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {similaritySearchRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ProductInfo) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ProductInfo) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ProductInfo.class);
            }
        }
    }

    public com.amazon.soap.ShoppingCart getShoppingCartRequest(com.amazon.soap.GetShoppingCartRequest getShoppingCartRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[18]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "GetShoppingCartRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {getShoppingCartRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ShoppingCart) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ShoppingCart) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ShoppingCart.class);
            }
        }
    }

    public com.amazon.soap.ShoppingCart clearShoppingCartRequest(com.amazon.soap.ClearShoppingCartRequest clearShoppingCartRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[19]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ClearShoppingCartRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {clearShoppingCartRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ShoppingCart) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ShoppingCart) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ShoppingCart.class);
            }
        }
    }

    public com.amazon.soap.ShoppingCart addShoppingCartItemsRequest(com.amazon.soap.AddShoppingCartItemsRequest addShoppingCartItemsRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[20]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "AddShoppingCartItemsRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {addShoppingCartItemsRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ShoppingCart) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ShoppingCart) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ShoppingCart.class);
            }
        }
    }

    public com.amazon.soap.ShoppingCart removeShoppingCartItemsRequest(com.amazon.soap.RemoveShoppingCartItemsRequest removeShoppingCartItemsRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[21]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "RemoveShoppingCartItemsRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {removeShoppingCartItemsRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ShoppingCart) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ShoppingCart) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ShoppingCart.class);
            }
        }
    }

    public com.amazon.soap.ShoppingCart modifyShoppingCartItemsRequest(com.amazon.soap.ModifyShoppingCartItemsRequest modifyShoppingCartItemsRequest) throws java.rmi.RemoteException {
        if (super.cachedEndpoint == null) {
            throw new org.apache.axis.NoEndPointException();
        }
        org.apache.axis.client.Call _call = createCall();
        _call.setOperation(_operations[22]);
        _call.setUseSOAPAction(true);
        _call.setSOAPActionURI("http://soap.amazon.com");
        _call.setSOAPVersion(org.apache.axis.soap.SOAPConstants.SOAP11_CONSTANTS);
        _call.setOperationName(new javax.xml.namespace.QName("http://soap.amazon.com", "ModifyShoppingCartItemsRequest"));

        setRequestHeaders(_call);
        setAttachments(_call);
        java.lang.Object _resp = _call.invoke(new java.lang.Object[] {modifyShoppingCartItemsRequest});

        if (_resp instanceof java.rmi.RemoteException) {
            throw (java.rmi.RemoteException)_resp;
        }
        else {
            extractAttachments(_call);
            try {
                return (com.amazon.soap.ShoppingCart) _resp;
            } catch (java.lang.Exception _exception) {
                return (com.amazon.soap.ShoppingCart) org.apache.axis.utils.JavaUtils.convert(_resp, com.amazon.soap.ShoppingCart.class);
            }
        }
    }

}
