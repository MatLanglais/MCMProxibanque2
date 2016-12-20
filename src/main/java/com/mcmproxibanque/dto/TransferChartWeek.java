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
public class TransferChartWeek implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITransferService transferService;
	private BarChartModel barModelWeek;

	@PostConstruct
	public void init() {
		createBarModelWeek();
	}

	public BarChartModel getBarModelWeek() {
		return barModelWeek;
	}

	private BarChartModel initBarModelWeek() {

		long transfersRange1 = 0;
		long transfersRange2 = 0;
		long transfersRange3 = 0;

		List<Transfer> transfersOfCurrentWeek = transferService.getTransfersOfCurrentWeek();
		for (Transfer transfer : transfersOfCurrentWeek) {
			if (transfer.getAmount() < 100) {
				transfersRange1++;
			} else if (transfer.getAmount() < 10000 && transfer.getAmount() > 100) {
				transfersRange2++;
			} else if (transfer.getAmount() > 10000) {
				transfersRange3++;
			}
		}
		BarChartModel modelWeek = new BarChartModel();

		ChartSeries transfers = new ChartSeries();
		transfers.set("< 100€", transfersRange1);
		transfers.set("Entre 100€ et 10 000€", transfersRange2);
		transfers.set("> 10 000€", transfersRange3);

		modelWeek.addSeries(transfers);

		return modelWeek;
	}

	private void createBarModelWeek() {
		barModelWeek = initBarModelWeek();

		barModelWeek.setTitle("Rapport hebdomadaire sur les transactions");
		barModelWeek.setLegendPosition("ne");

		Axis xAxis = barModelWeek.getAxis(AxisType.X);
		xAxis.setLabel("Montant de transactions");

		Axis yAxis = barModelWeek.getAxis(AxisType.Y);
		yAxis.setLabel("Nombre des transactions");
		yAxis.setMin(0);
	}

}
