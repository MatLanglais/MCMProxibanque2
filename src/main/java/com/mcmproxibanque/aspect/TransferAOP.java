package com.mcmproxibanque.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TransferAOP {

	private static final Logger LOGGER = LoggerFactory.getLogger(TransferAOP.class);

	@Pointcut("execution(* com.mcmproxibanque.service.ITransferService.doTransfer(..))")
	public void wiringMoney() {
	}

	@AfterThrowing("wiringMoney()")
	public void registerMoneyWire(ProceedingJoinPoint jp) {
		LOGGER.info("internal transfer info:" + jp.getArgs().toString());

	}
}
