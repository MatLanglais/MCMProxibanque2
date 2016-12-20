package com.mcmproxibanque.dto;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;

import org.primefaces.model.chart.Axis;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

@ManagedBean
public class TransferChart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private BarChartModel barModel;

	@PostConstruct
	public void init() {
		createBarModel();
	}

	public BarChartModel getBarModel() {
		return barModel;
	}

	private BarChartModel initBarModel() {
		
		long transfersRange1 = 10;
		long transfersRange2 = 20;
		long transfersRange3 = 15;
		
		
		
		BarChartModel model = new BarChartModel();

		ChartSeries transfers = new ChartSeries();
		transfers.set("< 100€", transfersRange1);
		transfers.set("100€ < < 10 000€", transfersRange2);
		transfers.set("> 10 000€", transfersRange3);
		
		model.addSeries(transfers);
		
		return model;
	}

	private void createBarModel() {
		barModel = initBarModel();

		barModel.setTitle("Rapport sur les transactions");
		barModel.setLegendPosition("ne");

		Axis xAxis = barModel.getAxis(AxisType.X);
		xAxis.setLabel("Nombre de transactions");

		Axis yAxis = barModel.getAxis(AxisType.Y);
		yAxis.setLabel("Montant des transactions");
		yAxis.setMin(0);
	}

}
