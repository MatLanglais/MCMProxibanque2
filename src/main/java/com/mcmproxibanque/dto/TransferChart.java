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

import com.mcmproxibanque.model.Transfer;
import com.mcmproxibanque.service.ITransferService;

@ManagedBean
public class TransferChart implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Autowired
	private ITransferService transferService;
	private BarChartModel barModelMonth;
	private BarChartModel barModelWeek;

	@PostConstruct
	public void init() {
		createBarModelMonth();
		createBarModelWeek();
	}

	public BarChartModel getBarModelMonth() {
		return barModelMonth;
	}

	public BarChartModel getBarModelWeek() {
		return barModelWeek;
	}
	
	private BarChartModel initBarModelMonth() {

		long transfersRange1 = 0;
		long transfersRange2 = 0;
		long transfersRange3 = 0;

		List<Transfer> transfersOfCurrentMonth = transferService.getTransfersOfCurrentMonth();
		for (Transfer transfer : transfersOfCurrentMonth) {
			if(transfer.getAmount()<100){
				transfersRange1 ++;
			}else if(transfer.getAmount()<10000 && transfer.getAmount()>100){
				transfersRange2 ++;
			}else if(transfer.getAmount()>10000){
				transfersRange3 ++;
			}
		}
		
		BarChartModel modelMonth = new BarChartModel();

		ChartSeries transfers = new ChartSeries();
		transfers.set("< 100€", transfersRange1);
		transfers.set("100€ < < 10 000€", transfersRange2);
		transfers.set("> 10 000€", transfersRange3);

		modelMonth.addSeries(transfers);

		return modelMonth;
	}

	private BarChartModel initBarModelWeek() {

		long transfersRange1 = 10;
		long transfersRange2 = 20;
		long transfersRange3 = 15;

		List<Transfer> transfersOfCurrentWeek = transferService.getTransfersOfCurrentWeek();
		for (Transfer transfer : transfersOfCurrentWeek) {
			if(transfer.getAmount()<100){
				transfersRange1 ++;
			}else if(transfer.getAmount()<10000 && transfer.getAmount()>100){
				transfersRange2 ++;
			}else if(transfer.getAmount()>10000){
				transfersRange3 ++;
			}
		}
		BarChartModel modelWeek = new BarChartModel();

		ChartSeries transfers = new ChartSeries();
		transfers.set("< 100€", transfersRange1);
		transfers.set("100€ < < 10 000€", transfersRange2);
		transfers.set("> 10 000€", transfersRange3);

		modelWeek.addSeries(transfers);

		return modelWeek;
	}

	private void createBarModelMonth() {
		barModelMonth = initBarModelMonth();

		barModelMonth.setTitle("Rapport mensuel sur les transactions");
		barModelMonth.setLegendPosition("ne");

		Axis xAxis = barModelMonth.getAxis(AxisType.X);
		xAxis.setLabel("Nombre de transactions");

		Axis yAxis = barModelMonth.getAxis(AxisType.Y);
		yAxis.setLabel("Montant des transactions");
		yAxis.setMin(0);
	}

	private void createBarModelWeek() {
		barModelWeek = initBarModelWeek();

		barModelWeek.setTitle("Rapport hebdomadaire sur les transactions");
		barModelWeek.setLegendPosition("ne");

		Axis xAxis = barModelWeek.getAxis(AxisType.X);
		xAxis.setLabel("Nombre de transactions");

		Axis yAxis = barModelWeek.getAxis(AxisType.Y);
		yAxis.setLabel("Montant des transactions");
		yAxis.setMin(0);
	}

}
