package mg.uha.miage.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import mg.uha.miage.entities.Client;
import mg.uha.miage.metier.interf.ClientMetierInterf;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

@Controller
@RequestMapping(value = "/Report/")
public class ExempleReporting {

	@Autowired
	private ClientMetierInterf clientMetierInterf;

	private static final Logger logger = LoggerFactory.getLogger(ExempleReporting.class);

	@RequestMapping(method = RequestMethod.GET, value = "pdf")
	public ModelAndView generatePdfReport(ModelAndView modelAndView) {

		logger.debug("--------------generate PDF report----------");

		Map<String, Object> parameterMap = new HashMap<String, Object>();

		List<Client> usersList = clientMetierInterf.listClient();

		JRDataSource JRdataSource = new JRBeanCollectionDataSource(usersList);

		parameterMap.put("datasource", JRdataSource);

		// pdfReport bean has ben declared in the jasper-views.xml file
		modelAndView = new ModelAndView("pdfReport", parameterMap);

		return modelAndView;

	}// generatePdfReport

}
