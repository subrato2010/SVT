
<ui:composition xmlns="http://www.w3.org/1999/xhtml"
	xmlns:f="http://java.sun.com/jsf/core"
	xmlns:h="http://java.sun.com/jsf/html"
	xmlns:ui="http://java.sun.com/jsf/facelets"
	xmlns:a4j="http://richfaces.org/a4j"
	xmlns:rich="http://richfaces.org/rich"
	template="templates/templateSVT.jsp">
	<ui:define name="title">
		Data Input
	</ui:define>
	<ui:define name="menu">
		<ui:include src="/templates/leftMenuSVT.jsp">
			<ui:param name="menu" value="#{dataInputController}"/>
		</ui:include>
	</ui:define>
	<ui:define name="tabs">
		<ui:include src="/inc/overallScoreTabs.jsp">
			<ui:param name="currentTab" value="datainput"/>
		</ui:include>
	</ui:define>
	<ui:define name="body_right_pannel">
		<!-- *************Body Right Pannel TOP Start ***************-->
		                                     
											<div id="right_pannel_social_doc">

            						
<p class="heading_text">This report is based on the following information:</p>


<table width="100%" border="0" cellpadding="0" cellspacing="0" style=" border:1px solid #999999; border-bottom:0px;">
  <tr>
    <td class="heading_left_text" valign="top">Company Name: </td>
    <td class="matter_right_text_table" valign="top">Netezza Corporation</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Description:</td>
    <td class="matter_right_text_table" valign="top">
    <p class="matter_right_text">Netezza understands that there's no point in storing your data if you can't find it again. The company provides data warehouse appliances used to manage large databases. Targeted toward government agencies and companies in data-intensive fields such as financial services and health care, Netezza's appliances integrate database, server, and storage functions, allowing customers to quickly analyze huge amounts of data. Netezza sells its products worldwide, primarily utilizing a direct sales force. Customers in North America account for about three-quarters of the company's sales; they include Acxiom, Amazon.com, The American Red Cross, AOL, ClarityBlue, Neiman Marcus, and Shoppers Drug Mart.</p>
	<p class="matter_right_text">Competitive Positioning: The US economy heavily influences business spending for software products. The success of programming companies depends heavily on strong technical expertise. The success of packaged-software companies depends on technical expertise and good marketing. Small software companies compete mainly by developing packaged products in small niches or producing custom products for individuals. Many small companies form alliances with larger ones to market their products. The packaged software industry is capital-intensive: average annual revenue per worker is about 360,000. The custom programming industry is relatively labor-intensive: average annual revenue per worker is about $175,000.</p>
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Competitors: </td>
    <td class="matter_right_text_table" valign="top">
    <p class="matter_right_text2">Oracle (Exadata)</p>
<p class="matter_right_text_table_new">According to this Oracle, consolidation in the business software industry is the wisest move. The enterprise software giant provides a range of tools for managing business data, supporting business operations, and facilitating collaboration and application development. Oracle also offers business applications for data warehousing, customer relationship management, and supply chain management. In recent years the company has aggressively used acquisitions to expand, including the purchases of PeopleSoft, Siebel Systems, and BEA Systems. In April 2009 the company announced plans for its most ambitious acquisition to date, the purchase of Sun for about $7.4 billion; the deal was completed in early 2010.</p>

<p class="matter_right_text2">Teradata</p> 
<p class="matter_right_text_table_new">Trillions of bytes of data don't faze Teradata. The company designs and implements enterprise data warehousing systems that store information about customers, finances, operations, and other business data. Its software includes its core database system, as well as applications for managing data, demand and supply chains, customers, compliance and risk, and performance. The company also offers consulting, support, and training services. Teradata targets companies in the entertainment, financial services, government, health care, insurance, manufacturing, retail, telecommunications, and transportation sectors. About half of sales are generated outside the US.</p>

<p class="matter_right_text2">IBM (DB2/SAS)</p>
<p class="matter_right_text_table_new">Big Blue? Try Huge Blue. International Business Machines (IBM) is the world's top provider of computer products and services. Among the leaders in almost every market in which it competes, the company focuses primarily on its growing services business, which accounts for more than half of sales. Though perhaps still best known for its hardware, its IT and business services units are among the largest in the world and serve customers across most industries. IBM is also one of the largest providers of both business software and semiconductors. The company's computing hardware legacy lives on in the form of its industry-leading enterprise server and storage products lines.</p>

    </td>
  </tr>
  
  <tr>
    <td class="heading_left_text" valign="top">Product(s):</td>
    <td class="matter_right_text_table" valign="top">
    
<p  class="matter_right_text">TwinFin: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/twinfin.aspx</font></p>
<p  class="matter_right_text">TwinFin i-Class:  <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/twinfin-i.aspx</font></p>
<p  class="matter_right_text">TwinFin Skimmer : <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/skimmer.aspx</font></p>
<p  class="matter_right_text">Retail Analytic Appliance: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/raa.aspx</font></p>
<p  class="matter_right_text">Netezza Spatial: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/spatial-analytics.aspx</font></p>
<p  class="matter_right_text">Netezza Mantra: <font class="hyperlink">http://datacompliance.netezza.com/</font></p>

    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Solution Segment(s):</td>
    <td class="matter_right_text_table" valign="top">
<p  class="matter_right_text">Data Warehousing: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/dw-appliance.aspx</font></p>
<p  class="matter_right_text">Data Compliance: <font class="hyperlink">http://datacompliance.netezza.com/?</font></p>
<p class="matter_right_text">Integrated Business Appliances:<font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/integrated.aspx</font></p>
<p  class="matter_right_text">Oracle Compatibility : <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/oracle.aspx</font></p>
<p  class="matter_right_text">Advanced Analytics: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/advanced-analytics.aspx</font></p>
<p  class="matter_right_text">Cloud Computing : <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-products/cloud.aspx</font></p>

</td>
  </tr>
  
   <tr>
    <td class="heading_left_text" valign="top">Partner Application(s):</td>
    <td class="matter_right_text_table" valign="top">
<p  class="matter_right_text">HCL Technologies Monte Carlo App</p>
<p  class="matter_right_text">Edge Technologies Extended SQL Toolkit</p>
<p  class="matter_right_text">Fuzzy Logix In Database Analytics Library</p>
<p  class="matter_right_text">Multi-threaded Inc Advanced Text Search Application</p>
<p  class="matter_right_text">Aperity's isalesbrandmanagement</p>
<p  class="matter_right_text">Pi Solutions Pi Profit Analytics</p>
<p  class="matter_right_text">RateIntegration Event Modeling Application</p>
<p  class="matter_right_text">Quantisense - Retail Analytic Appliance</p>
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Competitors' Product(s):</td>
    <td class="matter_right_text_table" valign="top">
    
    
<p  class="matter_right_text"><font class="matter_right_text2">Oracle Exadata</font><font class="hyperlink1">http://www.oracle.com/us/products/database/exadata/index.htm</font></p>
<p  class="matter_right_text3">- Exadata Smart Flash Cache</p>
<p  class="matter_right_text3">- Exadata Hybrid Columnar Compression</p>

<p  class="matter_right_text"><font class="matter_right_text2">Teradata</font><font class="hyperlink1">http://www.teradata.com</font></p>

<p  class="matter_right_text">Database Software: Teradata Database 13.0</p>

<p  class="matter_right_text">Applications:</p>
<p  class="matter_right_text3">- Teradata Airline Decisions</p>
<p  class="matter_right_text3">- Teradata Demand Chain Management</p>
<p  class="matter_right_text3">- Teradata Product Information Management</p>
<p  class="matter_right_text3">- Teradata Tax Solutions</p>
<p  class="matter_right_text3">- Teradata Warehouse Miner</p>
<p  class="matter_right_text3">- Teradata Customer Data Integration</p>
<p  class="matter_right_text3">- Teradata Geospatial</p>
<p  class="matter_right_text3">- Teradata Relationship Manager</p>
<p  class="matter_right_text3">- Teradata Transportation Decisions</p>
<p  class="matter_right_text3">- Teradata Decision Experts</p>
<p  class="matter_right_text3">- Teradata Integrated Web Intelligence</p>
<p  class="matter_right_text3">- Teradata Retail Decisions</p>
<p  class="matter_right_text3">- Teradata Value Analyzer</p>
<p  class="matter_right_text3">- Teradata Enterprise Analytics Cloud</p>

<p  class="matter_right_text">Platform Family:</p>

<p  class="matter_right_text3">- Teradata Data Mart Appliance</p>
<p  class="matter_right_text3">- Teradata Extreme Data Appliance</p>
<p  class="matter_right_text3">- Teradata Data Warehouse Appliance</p>
<p  class="matter_right_text3">- Teradata Accelerate Packages</p>
<p  class="matter_right_text3">- Teradata Active Enterprise Data Warehouse</p>

<p  class="matter_right_text">Teradata Enterprise Analytics Cloud:</p>
<p  class="matter_right_text3">-	Teradata Agile Analytics Cloud</p>
<p  class="matter_right_text3">-	Teradata Elastic Mart Builder tool</p>
<p  class="matter_right_text3">o	Teradata Express Teradata Express on Amazon EC2</p>
<p  class="matter_right_text3">o	Teradata Express for VMware Player</p>

<p  class="matter_right_text">Tools &amp; Utilities:</p>
<p  class="matter_right_text3">- Teradata Database Management</p>
<p  class="matter_right_text3">- Teradata Utility Pack</p>
<p  class="matter_right_text3">- Teradata Load and Unload Utilities</p>
<p  class="matter_right_text3">- Teradata Query Director</p>
<p  class="matter_right_text3">- Teradata Analyst Pack</p>

<p  class="matter_right_text">Roadmaps &amp; Models:</p>

<p  class="matter_right_text"><font class="matter_right_text2">Logical Data Model (LDM)</font></p>
<p  class="matter_right_text3">- Teradata Communications Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Financial Services Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Healthcare Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Insurance Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Manufacturing Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Media Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Retail Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Transportation and Logistics Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Travel and Hospitality Industry Logical Data Model</p>
<p  class="matter_right_text3">- Teradata Utilities Logical Data Model</p>

<p  class="matter_right_text"><font class="matter_right_text2">Enterprise Data Warehouse Roadmap (EDWR)</font></p>
<p  class="matter_right_text3">- Enterprise Data Warehouse Roadmap Modeling</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Communications</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Financial Services</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Healthcare</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Insurance</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Manufacturing</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Retail</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Transportation and Logistics</p>
<p  class="matter_right_text3">- Teradata Enterprise Data Warehouse Roadmap for Travel and Hospitality</p>

<p  class="matter_right_text">Backup Archive &amp; Store (BAR):</p>
<p  class="matter_right_text3">- Teradata Tape Libraries-Tape Encryption</p>
<p  class="matter_right_text3">- BakBone NetVault</p>
<p  class="matter_right_text3">- Teradata Disk-Based Backup</p>
<p  class="matter_right_text3">- Symantec NetBackup</p>


<p  class="matter_right_text"><font class="matter_right_text2">IBM (DB2/SAS):</font><font class="hyperlink1">http://www-01.ibm.com/software/data/db2/</font></p>
<p  class="matter_right_text3">- DB2 for Linux, UNIX, and Windows</p>
<p  class="matter_right_text4">Enterprise Server Edition</p>
<p  class="matter_right_text4">Workgroup Server Edition</p>
<p  class="matter_right_text4">Express-C</p>
<p  class="matter_right_text4">Express Edition</p>
<p  class="matter_right_text3">- DB2 Everyplace</p>
<p  class="matter_right_text4">Everyplace Database Edition</p>
 <p  class="matter_right_text4">Everyplace Enterprise Edition</p>
<p  class="matter_right_text3">- DB2 for z/OS</p>
<p  class="matter_right_text4">DB2 for z/OS</p>
<p  class="matter_right_text4">DB2 Tools for z/OS</p>
<p  class="matter_right_text4">DB2 for z/OS Value Unit Edition</p>
<p  class="matter_right_text4">InfoSphere Warehouse on System </p>
    
    
    
    </td>
  </tr>
  
    <tr>
    <td class="heading_left_text" valign="top">Brand(s):</td>
    <td class="matter_right_text_table" valign="top">Netezza, TwinFin</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Industry Verticals:</td>
    <td class="matter_right_text_table" valign="top">
<p  class="matter_right_text">Digital Media:<font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-industries/digital-media.aspx</font></p>
<p  class="matter_right_text">Energy: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-industries/energy.aspx</font></p>
<p  class="matter_right_text">Financial Services : <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-industries/financial.aspx</font></p>
<p  class="matter_right_text">Government: <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-industries/government.aspx</font></p>
<p  class="matter_right_text">Health &amp; Life Sciences:  <font class="hyperlink">http://www.netezza.com/data-warehouse-appliance-industries/lifesciences.aspx</font></p>
<p  class="matter_right_text">Retail/Consumer Products:<font class="hyperlink"> http://www.netezza.com/data-warehouse-appliance-industries/retail.aspx</font></p>
<p  class="matter_right_text">Telecommunications:<font class="hyperlink"> http://www.netezza.com/data-warehouse-appliance-industries/communications.aspx</font></p>
 
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Blog(s):</td>
    <td class="matter_right_text_table" valign="top">
<p  class="matter_right_text">Mike Baum - Our Narmy Chief <font class="hyperlink">http://www.enzeecommunity.com/blogs/experience</font></p>
<p  class="matter_right_text">David Birmingham - Gather round the grill <font class="hyperlink">http://www.enzeecommunity.com/blogs/grill</font></p>
<p  class="matter_right_text">Shawn Dolley - Previously impossible <font class="hyperlink">http://previouslyimpossible.wordpress.com/</font></p>
<p  class="matter_right_text">Brian Enzee - soundbytes	Brian Enzee123 <font class="hyperlink">http://www.enzeecommunity.com/blogs/bytes</font></p>
<p  class="matter_right_text">Phil Francisco - Thinking inside the box <font class="hyperlink">http://www.enzeecommunity.com/blogs/nzblog</font></p>
<p  class="matter_right_text">Prat Moghe - Data Auditing Blog <font class="hyperlink">http://datacompliance.netezza.com/data_auditing_blog/</font></p>
<p  class="matter_right_text">Brad Terrell - Data Drives Media <font class="hyperlink">http://www.datadrivesmedia.com/</font></p>
<p  class="matter_right_text">Tim Young - Crossing the line <font class="hyperlink">http://www.enzeecommunity.com/blogs/crossing</font></p>
<p  class="matter_right_text">Bob Doyle - Data Liberators <font class="hyperlink">http://www.dataliberators.com/</font></p>
</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Targeted Keyword Terms:</td>
    <td class="matter_right_text_table2" valign="top">
    
                        <table width="98%" border="0" cellpadding="0" cellspacing="0">
                          <tr>
                            <td valign="top" width="250px" style="border-right:1px solid #999999">
                            
                           <p  class="matter_right_text2"> Netezza</p>
<p  class="matter_right_text">Product/Service: </p>
<p  class="matter_right_text3">Netezza TwinFin</p>
<p  class="matter_right_text3">Netezza TwinFin Skimmer</p>
<p  class="matter_right_text3">Netezza Retail Analytic Appliance</p>
<p  class="matter_right_text3">Netezza Spatial</p>
<p  class="matter_right_text3">Netezza Mantra</p>

<p  class="matter_right_text">Other: Netezza data liberators</p>

<p  class="matter_right_text">Public Figures:</p>
 <p  class="matter_right_text3">Netezza Jim Baum</p>
<p  class="matter_right_text3">Netezza Phil Francisco</p>
<p  class="matter_right_text3"> 	Netezza Tim Young</p>
<p  class="matter_right_text3"> 	Netezza Pat Scannell</p>
<p  class="matter_right_text3"> 	Netezza Mike Baum </p>
 <p  class="matter_right_text3">	Netezza David Birmingham</p>
<p  class="matter_right_text3"> 	Netezza Shawn Dolley </p>
<p  class="matter_right_text3"> 	Netezza Brian Enzee</p>
 <p  class="matter_right_text3">	Netezza Prat Moghe</p>
 <p  class="matter_right_text3">	Netezza Brad Terrell</p>
 <p  class="matter_right_text3">	Netezza Bob Doyle</p>

                            
                            </td>
                            <td valign="top" width="180px" style="border-right:1px solid #999999">
                            
 <p  class="matter_right_text2">Oracle</p>
<p  class="matter_right_text">Product/Service:</p>
<p  class="matter_right_text3">Exadata Smart Flash Cache</p>
<p  class="matter_right_text3">Exadata Hybrid Columnar Compression</p>
<p  class="matter_right_text3">Sun Oracle Database Machine</p>

<p  class="matter_right_text">Brand:</p>
<p  class="matter_right_text3">Oracle Exadata</p>
                           
                            
                            
                            </td>
                             <td valign="top" width="180px" style="border-right:1px solid #999999">
                            
<p  class="matter_right_text2"> Teradata</p>
<p  class="matter_right_text">Product/Service:</p>
<p  class="matter_right_text3">Teradata Enterprise Analytics Cloud</p>
<p  class="matter_right_text3">Teradata Enterprise Analytics Cloud:</p>
<p  class="matter_right_text3">Teradata Agile Analytics Cloud</p>
<p  class="matter_right_text">Brand:</p>
<p  class="matter_right_text3">Teradata</p>
                           
                            
                            </td>
                           <td valign="top" width="180px">
                            
 <p  class="matter_right_text2"> IBM</p>
<p  class="matter_right_text">Product/Service:</p>
<p  class="matter_right_text3">IBM DB2</p>
<p  class="matter_right_text3">IBM Express-C</p>
<p  class="matter_right_text3">DB2 z/OS</p>
<p  class="matter_right_text">Brand:</p>
<p  class="matter_right_text3">IBM DB2</p>
                           
                            
                            </td>
                          </tr>
                        </table>

    
    
    </td>
  </tr>
  
    <tr>
    <td class="heading_left_text"> </td>
    <td class="matter_right_text_table" valign="top">
    
 <p  class="matter_right_text">   Industry:</p>

<p  class="matter_right_text3"> 	Data Warehousing</p>
<p  class="matter_right_text4">o	Business intelligence</p>
<p  class="matter_right_text4">o	Data Compliance</p>
<p  class="matter_right_text4">o	Integrated Business Appliances</p>
<p  class="matter_right_text4">o	Oracle Compatibility</p>
<p  class="matter_right_text4">o	Advanced Analytics</p>
<p  class="matter_right_text4">o	Cloud Computing</p>
<p  class="matter_right_text4">o	Digital Media</p>
<p  class="matter_right_text4">o	Energy</p>
<p  class="matter_right_text4">o	Financial </p>
<p  class="matter_right_text4">o	Government</p>
<p  class="matter_right_text4">o	Health &amp; Life Sciences</p>
<p  class="matter_right_text4">o	Retail</p>
<p  class="matter_right_text4">o	Consumer</p>
<p  class="matter_right_text4">o	Telecommunications</p>
<p  class="matter_right_text4">o	Data Integration</p>

    
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Targeted SEO Keywords:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Public Figure(s):</td>
    <td class="matter_right_text_table">
<p  class="matter_right_text">Jim Baum, CEO</p>
<p  class="matter_right_text">Profile: Wikipedia <font class="hyperlink">Crunchbase Zoominfo LinkedIn</font></p>

<p  class="matter_right_text">Pat Scannell, CFO</p>
<p  class="matter_right_text">Profile: Wikipedia Crunchbase Zoominfo <font class="hyperlink">LinkedIn</font></p>

<p  class="matter_right_text">Phil Francisco, VP Product Mgmt/Mkting</p>
<p  class="matter_right_text">Profile: Wikipedia Crunchbase Zoominfo <font class="hyperlink">LinkedIn</font></p>

<p  class="matter_right_text">Tim Young, VP Corporate Communications</p>
<p  class="matter_right_text">Profile: <font class="hyperlink">Wikipedia Crunchbase Zoominfo LinkedIn</font></p>

</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Trackback (a list of URLs and domains to search for trackbacks):</td>
    <td class="matter_right_text_table" valign="top">URL: not available</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Website Domain(s):</td>
    <td class="matter_right_text_table" valign="top">
<p class="hyperlink">http://www.netezza.com</p>
<p class="hyperlink">http://www.enzeecommunity.com</p>
<p class="hyperlink">http://www.dataliberators.com</p>
<p class="hyperlink">http://go.netezza.com</p>

    
    
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Date Range:</td>
    <td class="matter_right_text_table" valign="top">Variable depending upon the data source</td>
  </tr>
    <tr>
    <td class="heading_left_text" valign="top">Social Media Presence :</td>
    <td class="matter_right_text_table" valign="top">
<p  class="matter_right_text">Twitter User Name(s):</p> 
<p  class="matter_right_text">1. Netezza (<font class="hyperlink">cgpallotta@gmail.com/molly123</font>) <font class="hyperlink">http://www.twitter.com/netezza</font></p>
<p  class="matter_right_text">2. Data Liberators (dataliberators/netezza1) <font class="hyperlink">http://www.twitter.com/dataliberators</font></p>
<p  class="matter_right_text">3. Brad Terrell (Login?) <font class="hyperlink">http://twitter.com/bradterrell</font></p>

<p  class="matter_right_text">Facebook Fan Page: <font class="hyperlink">www.facebook.com/NetezzaCorp</font></p>
<p  class="matter_right_text">Facebook Profile Page: Brian Enzee (<font class="hyperlink">brian@enzeecommunity.com/Enzee123</font>) <font class="hyperlink">http://www.facebook.com/enzee</font></p>

<p  class="matter_right_text">Flickr: N/A</p>
</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Google Analytics Login:</td>
    <td class="matter_right_text_table" valign="top">TBD</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">PostRank Login:</td>
   	<td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Traditional and Electronic Media:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">YouTube Channel &amp; Video:</td>
    <td class="matter_right_text_table" valign="top">
<p  class="matter_right_text"> Channel #1: NetezzaMC (NetezzaMC/Netezza) <font class="hyperlink">http://www.youtube.com/netezzamc</font></p>
<p  class="matter_right_text">Channel #2: Data Liberators (dataliberators/netezza1) <font class="hyperlink">http://www.youtube.com/user/dataliberators</font></p>
   
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Slideshare:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Specific Online Campaigns:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  
  
  <tr>
    <td class="heading_left_text" valign="top">Specific Offline Campaigns:</td>
    <td class="matter_right_text_table2" valign="top">
    
    
    
    
                                            <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                          <tr>
                                            <td  class="matter_right_text_table1" width="10%">CAMPAIGN</td>
                                            <td  class="matter_right_text_table1" width="10%">DATE</td>
                                            <td  class="matter_right_text_table1" width="20%"># REGISTRANTS</td>
                                            <td  class="matter_right_text_table1" width="20%"># ATTENDEES / LEADS</td>
                                            <td  class="matter_right_text_table1" width="20%">EVENT TYPE</td>
                                            <td  class="matter_right_text_table" width="20%">REGISTRATION URL</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">NRF 2010</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">01/12/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">17000</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">275</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://events.nrf.com/annual2011/Public/Content.aspx?ID=7541</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">TWDI/Pentaho/Telcel Webinar</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">02/04/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">1004</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">425</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Webinar</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://tdwi.org/webcasts/2010/01/revolutionary-bi-changing-the-rules-of-the-game.aspx?tc=page0</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Predictive Analytics World</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">02/17/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">250</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">242</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.predictiveanalyticsworld.com/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">TDWI Winter World Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">02/21/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">900</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">224</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://events.tdwi.org/events/las-vegas-world-conference-2010/home.aspx</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Glenn Mills PA Networking Event</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">03/31/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">21</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">18</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.netezza.com/pa/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Fuzzy Logix Webinar (1)</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">03/30/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">237</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%"></td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Webinar</td>
                                            <td  class="hyperlink3" valign="top" width="20%">https://netezza.webex.com/mw0305l/mywebex/default.do?siteurl=netezza&amp;service=6</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Gartner BI Summit</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/11/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">3500</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.gartner.com/it/page.jsp?id=1118023</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">SAS Global Forum</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/11/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">3500</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://support.sas.com/events/sasglobalforum/2010/ index.html</td>
                                          </tr>

                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Canberra Executive Breakfast</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/13/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://now.eloqua.com/es.asp?s=1326&amp; e=1290&amp;elq=8d0e244230964218b0f9575006a182f2</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Melbourne Executive Breakfast</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/14/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://now.eloqua.com/es.asp?s=1326&amp;e=1312&amp; elq=2a71e4d4cf614261b645008de871e7c9</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Salon BI 2010</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/14/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">500</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.salonbi.com/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Houston Dinner</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/15/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">20</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%"></td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%"></td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Adastra IMX Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/15/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">300</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.imconference.ca/default.asp?active_page_id=77</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">BIO IT World</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/20/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">1700</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">https://chidb.com/register/2010/bioitexpo/reg.asp</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">NGT Summit Europe</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/20/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">50</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%"></td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.ngtsummit.com/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Jakarta Executive Breakfast</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/21/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%"></td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Fuzzy Logix Webinar (2)</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/22/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%"></td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Webinar</td>
                                            <td  class="hyperlink3" valign="top" width="20%">https://netezza.webex.com/mw0305l/mywebex/default.do? siteurl=netezza&amp;service=6</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">DC Executive Dinner</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/29/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.netezza.com/dc0210/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Data Governance Seminar</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/05/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://go.netezza.com/content/BI?elq=9 e776db3d2304d1494e4dc0976388625</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">TDWI Spring World Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/09/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://tdwi.org/pages/education/conferences.aspx</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Immix Spy Museum Seminar</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/11/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%"></td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">The Cable Show</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/11/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%"></td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Pharma S&amp;M Seminar (NJ)</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/19/01</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.netezza.com/princeton/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Red Sox Game</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/19/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Regional Event</td>
                                            <td  class="hyperlink3" valign="top" width="20%">N/A</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">DoDIIS</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/23/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">https://www.ncsi.com/dodiis10/index.shtml</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">American Medical Informatics Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/25/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://amianow2010.amia.org/registration-0</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">AHIP</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">06/09/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.ahip.org/links/institute2010/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Enzee Universe</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">06/21/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">User Conference</td>
                                            <td  class="hyperlink3" valign="top" width="20%">www.enzeeuniverse.com</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">TDWI Summer World Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">08/16/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://tdwi.org/pages/education/conferences.aspx</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Oracle World Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">09/20/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.oracle.com/us/openworld/index.htm</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Pharma Force</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">10/05/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">https://secure.wbresearch.com/ SRS2k.dll/ChooseRegistration</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">TDWI Fall World Conference</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">11/08/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://tdwi.org/pages/education/conferences.aspx</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Fraud and Abuse Confernece</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">11/13/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://symposium2010.amia.org/registration-0</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Epsilon Symposium </td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">04/07/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">175</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.epsilon.com/symposium/</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">DemandBetter</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">05/19/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">??</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.demandtec.com/demandbetter-2010</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Merkle CRM Conference </td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">06/07/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">200</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.mercleinc/summit2010</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">NRFTech 201</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">08/15/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">100</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://events.nrf.com/nrftech2010/public/enter.aspx</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">NRF Big Show</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">01/09/11</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">18000</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://events.nrf.com/annual2011/public/enter.aspx</td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">Digital Summit 2010</td>
                                            <td  class="matter_right_text_table1" valign="top" width="10%">06/10/10</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">???</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">TBC</td>
                                            <td  class="matter_right_text_table1" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink3" valign="top" width="20%">http://www.247realmedia.com/digitalsummit/ </td>
                                          </tr>
                                          <tr>
                                            <td  class="matter_right_text_table6" valign="top" width="10%">RSA Conference &amp; Expo</td>
                                            <td  class="matter_right_text_table6" valign="top" width="10%">03/01/10</td>
                                            <td  class="matter_right_text_table6" valign="top" width="20%">15,000</td>
                                            <td  class="matter_right_text_table6" valign="top" width="20%">143</td>
                                            <td  class="matter_right_text_table6" valign="top" width="20%">Tradeshow</td>
                                            <td  class="hyperlink4" valign="top" width="20%">www.rsaconference.com</td>
                                          </tr>

                                        </table>

    
    
    
    </td>
  </tr>  
    <tr>
    <td class="heading_left_text" valign="top">Private Forums &amp; Communities:</td>
    <td class="matter_right_text_table" valign="top">Jive for Community (admin/cl34r5p4c3) http://www.enzeecommunity.com/admin</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Other Proprietary Data Sources:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  
    <tr>
    <td class="heading_left_text" valign="top">PPC Campaigns:</td>
    <td class="matter_right_text_table2" valign="top">
    
                                       <table width="100%" border="0" cellpadding="0" cellspacing="0">
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">Keyword</td>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="10%">Estimated <br />Impressions</td>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="10%">Estimated <br />Avg. CPC</td>
                                        <td  class="matter_right_text_table3" valign="top" align="center" width="10%">Local Monthly <br />Searches</td>
                                      </tr>
                                      <tr>
                                        <td colspan="4"  class="matter_right_text_table3" valign="top">Web Analytics</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"best web analytics software"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"best web analytics tools"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"best web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">5</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$9.01</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">590</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"on premise web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"on site web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"online web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">170</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"sampling in web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"the best web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                       <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"top web analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics best practices"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics data sampling"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                       <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics data"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                       <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics database"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics marketing"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                       <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics optimization"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics segmentation"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analytics solutions"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">2</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$5.32 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">210</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web marketing analytics"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"website analytics data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"website analytics database"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05 </td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td colspan="4"></td>
                                      </tr>
                                      
                                      
                                      <tr>
                                        <td colspan="4" class="matter_right_text_table5" valign="top" align="center">Web Data</td>
                                      </tr>                                     

                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data collector"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data extraction software"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">2</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$2.54</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">210</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data extraction tool"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data extraction tools"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data extraction"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">43</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$1.78</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">1300</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data mining tools"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data mining"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">32</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$2.85</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">1900</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web data warehousing"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web datamining"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">2</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$4.59</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">22</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web site data extraction"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">73</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web site data mining"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td colspan="4"></td>
                                      </tr>
                                      <tr>
                                        <td colspan="4"  class="matter_right_text_table5" valign="top">Web Analysis</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"on premise website analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web log file analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">2</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$14.45</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">210</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web logs analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">28</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web marketing analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web path analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">16</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web server log file analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">5</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$13.17</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">210</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web site log analysis"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">73</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"website analysis data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center"  width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"website analysis database"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"website data mining"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web analysis data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%"></td>
                                       	<td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"analyze web log files"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">0</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"marketing data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web business intelligence"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text_table1" valign="top" align="center" width="20%">"web enabled data warehouse"</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">0</td>
                                        <td  class="matter_right_text_table4" valign="top" align="center" width="10%">$0.05</td>
                                        <td  class="matter_right_text_table5" valign="top" align="center" width="10%">-</td>
                                      </tr>
                                      <tr>
                                        <td  class="matter_right_text" valign="top" align="center" width="20%">"web visitor tracking"</td>
                                        <td  class="matter_right_text" valign="top" align="center" width="10%"></td>
                                        <td  class="matter_right_text" valign="top" align="center" width="10%"></td>
                                        <td  class="matter_right_text" valign="top" align="center" width="10%"></td>
                                      </tr>
                                      
                                    </table>
                                     
    
    
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Mobile:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">iPod:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Other Apps &amp; Widgets:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Podcasts: </td>
    <td class="matter_right_text_table" valign="top">
  <p class="hyperlink">http://www.cisco.com/survey/exit.html?http://itunes.apple.com/WebObjects/MZStore.woa/wa/viewPodcast?id=303281252</p>
  <p class="hyperlink">http://tools.cisco.com/newsroom/contactSearch/archive/?type=pod</p>

    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Email Subscription:</td>
    <td class="matter_right_text_table" valign="top">
  <p class="hyperlink">https://tools.cisco.com/gdrp/coiga/showsurvey.do?surveyCode=835&amp;keyCode=137148_1</p>
  <p class="hyperlink">http://resources.cisco.com/cocoon/resources/survey.xml?survey_id=394534</p>
  
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Survey:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">RSS:</td>
    <td class="matter_right_text_table" valign="top">
            <p class="matter_right_text">RSS #1: <font class="hyperlink2">TBD</font></p> 
            <p class="matter_right_text">RSS #2: <font class="hyperlink2">TBD</font></p> 
            <p class="matter_right_text">RSS #3: <font class="hyperlink2">TBD</font></p> 
    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Nielsen NetRatings SiteCensus :</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Google Groups:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">SMS:</td>
    <td class="matter_right_text_table" valign="top">N/A</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">LinkedIn : </td>
    <td class="matter_right_text_table" valign="top">
<p class="matter_right_text">User Group: <font class="hyperlink2">http://www.linkedin.com/groups?home=&amp;gid=2112139&amp;trk=anet_ug_hm</font></p>
<p class="matter_right_text">Event : Enzee Universe 2010 <font class="hyperlink2">http://events.linkedin.com/Enzee-Universe-2010/pub/215659</font></p>
<p class="matter_right_text">Company Profile:
<font class="hyperlink2">http://www.linkedin.com/companies/netezza?trk=co_search_results&amp;goback=%2Ecps_1269978292026_1</font></p>

    </td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">CRM :</td>
   <td class="matter_right_text_table" valign="top">Salesforce.com (Mattcarter@socialtality.com/socialtality09)</td>
  </tr>
  <tr>
    <td class="heading_left_text" valign="top">Email:</td>
    <td class="matter_right_text_table" valign="top">Eloqua (Matt.Carter/TwinFin10) <font class="hyperlink2">https://secure.eloqua.com/</font></td>
  </tr>  
  </table>


                                               
                                                
                                       
                                     </div>
	</ui:define>
</ui:composition>
