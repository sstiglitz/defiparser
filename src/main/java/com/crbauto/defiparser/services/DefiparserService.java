package com.crbauto.defiparser.services;

import java.util.List;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.crbauto.defiparser.entities.DMSSUCI;
import com.crbauto.defiparser.repositories.DMSSUCIRepository;

@Component
public class DefiparserService {

	@Autowired
	DMSSUCIRepository dmssuciRepository;
	
	public void processDefiXml(String defiXmlStr) {
		
		try {
			Document defiXml = DocumentHelper.parseText(defiXmlStr);
			
			List<Node> dmsReportNodes = defiXml.selectNodes("/LoanApplications/LoanApplication/LoanApplicationStates/LoanApplicationState/Customers/Customer/Reports/Report[@bureau='EX']");
			for (Node dmsReportNode : dmsReportNodes) {
				Element dmsReportEle = (Element) dmsReportNode;
				Document rawXml = DocumentHelper.parseText(dmsReportEle.valueOf("@raw_xml"));
				
				DMSSUCI dmssuci = new DMSSUCI(); 
				dmssuci.setReportId(Long.parseLong(dmsReportEle.valueOf("@deal_detail_id")));
				dmssuci.setSuci001(Integer.parseInt(rawXml.valueOf("/Response/DMSXML/DMSCommon/Products/Product[2]/ProductResult/SUsegments/SUCIsegment[1]/@SUCI001")));
				dmssuci.setSuci002(Integer.parseInt(rawXml.valueOf("/Response/DMSXML/DMSCommon/Products/Product[2]/ProductResult/SUsegments/SUCIsegment[1]/@SUCI002")));
				
				dmssuciRepository.save(dmssuci);
			}
			
		} catch (DocumentException e) {
			e.printStackTrace();
		}
		 
		
	}
	
}
