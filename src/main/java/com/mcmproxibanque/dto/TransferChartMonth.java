package com.mcmproxibanque.dto;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.mcmproxibanque.model.Transfer;
import com.mcmproxibanque.service.ITransferService;


@ManagedBean
@Component
public class TransferChartMonth implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITransferService transferService;
	private BarChartModel barModelMonth;
	
	@PostConstruct
	public void init() {
		createBarModelMonth();
	}

	public BarChartModel getBarModelMonth() {
		return barModelMonth;
	}

	private BarChartModel initBarModelMonth() {

		long transfersRange1 = 0;
		long transfersRange2 = 0;
		long transfersRange3 = 0;

		List<Transfer> transfersOfCurrentMonth = transferService.getTransfersOfCurrentMonth();
		for (Transfer transfer : transfersOfCurrentMonth) {
			if (transfer.getAmount() < 100) {
				transfersRange1++;
			} else if (transfer.getAmount() < 10000 && transfer.getAmount() > 100) {
				transfersRange2++;
			} else if (transfer.getAmount() > 10000) {
				transfersRange3++;
			}
		}

		BarChartModel modelMonth = new BarChartModel();

		ChartSeries transfers = new ChartSeries();
		transfers.set("< 100€", transfersRange1);
		transfers.set("Entre 100€ et 10 000€", transfersRange2);
		transfers.set("> 10 000€", transfersRange3);

		modelMonth.addSeries(transfers);

		return modelMonth;
	}

	
	private void createBarModelMonth() {
		barModelMonth = initBarModelMonth();

		barModelMonth.setTitle("Rapport mensuel sur les transactions");
		barModelMonth.setLegendPosition("ne");

		Axis xAxis = barModelMonth.getAxis(AxisType.X);
		xAxis.setLabel("Montant de transactions");

		Axis yAxis = barModelMonth.getAxis(AxisType.Y);
		yAxis.setLabel("Nombre des transactions");
		yAxis.setMin(0);
	}


	
}
