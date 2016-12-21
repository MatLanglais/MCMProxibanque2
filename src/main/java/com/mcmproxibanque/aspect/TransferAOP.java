package com.mcmproxibanque.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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

	@Around("wiringMoney()")
	public void registerMoneyWire(ProceedingJoinPoint jp) {
		try{
			jp.proceed();
			LOGGER.info("internal transfer info:" + jp.getArgs().toString());
			
		}catch(Throwable e){
			LOGGER.info("internal transfer: " + jp.getArgs().toString()+" failed");
	}
		
	}
}
