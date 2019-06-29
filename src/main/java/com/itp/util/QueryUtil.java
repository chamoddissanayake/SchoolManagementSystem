package com.itp.util;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import com.itp.exception.QueryLoadingException;

public class QueryUtil extends CommonUtil{
	
	/** Initialize logger */
	public static final Logger log = Logger.getLogger(QueryUtil.class.getName());
	
	private static QueryUtil SINGLE_INSTANCE = null;
	
	private NodeList nodeList;
	
	private QueryUtil() throws QueryLoadingException {
    	
		
			try {
				/*
				 * Read the Query.xml file and read each query node into node
				 * list. It refers tag name query
				 */
				nodeList = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(QueryUtil.class.getResourceAsStream("Query.xml"))
							.getElementsByTagName(CommonConstants.TAG_NAME);
				
			} catch (SAXException | IOException |ParserConfigurationException  e) {
				log.log(Level.SEVERE, e.getMessage());
				throw new QueryLoadingException("Error loading queries from files",e);
			}
    }

		public static QueryUtil getInstance() throws QueryLoadingException {
		    if (SINGLE_INSTANCE == null) {  
		      synchronized(QueryUtil.class) {
		    	  if (SINGLE_INSTANCE == null) {
		              SINGLE_INSTANCE = new QueryUtil();
		          }
		      }
		    }
		    return SINGLE_INSTANCE;
		}


		/**
		 * This method read the Query.xml file and retrieve the query by
		 * query id.
		 * 
		 * @param id
		 *            QueryID to retrieve elements
		 * 
		 * @return String formatted query will be returned as output
		 * 
		 * @throws ParserConfigurationException
		 *             - Indicates a serious configuration error.
		 * @throws IOException
		 *             - This class is the general class of exceptions produced by
		 *             failed or interrupted I/O operations.
		 * @throws SAXException
		 *             - Encapsulate a general SAX error or warning.
		 * @throws QueryLoadingException 
		 * 
		 * 
		 */

		public String queryByID(String id) throws SAXException, IOException, ParserConfigurationException, QueryLoadingException {
			/*
			 * Extract the node from node list using query id query id is taken from
			 * query node attribute
			 */
			for (int value = 0; value < nodeList.getLength(); value++) {
				Element element = (Element) nodeList.item(value);
				if (element.getAttribute(CommonConstants.ATTRIB_ID).equals(id))
					return element.getTextContent().trim();
			}
			throw new QueryLoadingException("Query not found for the Id:"+id);
		}
}
