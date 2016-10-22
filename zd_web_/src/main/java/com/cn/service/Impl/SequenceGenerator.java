package com.cn.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.support.incrementer.OracleSequenceMaxValueIncrementer;
import org.springframework.stereotype.Service;

@Service
public class SequenceGenerator {
   private static final String seq_url="seq_url";
   private static final String product_seq="t_productseq";
   private static final String t_member_seq="t_member_seq";
   private static final String t_staff="t_staffs";
   private static final String  t_m_p="t_m_p";
   
   @Autowired
   public OracleSequenceMaxValueIncrementer oracleSequenceMaxValueIncrementer;
   
   
   public Long nextRet_m_pOrderseq(){
	   oracleSequenceMaxValueIncrementer.setIncrementerName(t_m_p);
	   
	  Long currval=oracleSequenceMaxValueIncrementer.nextLongValue();
	  
	  return currval;
   }
   
   
   public Long nextRechargeOrderseq(){
	   oracleSequenceMaxValueIncrementer.setIncrementerName(seq_url);
	   
	  Long currval=oracleSequenceMaxValueIncrementer.nextLongValue();
	  
	  return currval;
   }
   
   public Long nextproduct_seq(){
	   oracleSequenceMaxValueIncrementer.setIncrementerName(product_seq);
	   
		  Long currval=oracleSequenceMaxValueIncrementer.nextLongValue();
		  
		  return currval;
   }
   
   
   
   public Long nextmember_seq(){
	   oracleSequenceMaxValueIncrementer.setIncrementerName(t_member_seq);
	   
		  Long currval=oracleSequenceMaxValueIncrementer.nextLongValue();
		  
		  return currval;
   }
   
   public Long staff_seq(){
	   oracleSequenceMaxValueIncrementer.setIncrementerName(t_staff);
	   
		  Long currval=oracleSequenceMaxValueIncrementer.nextLongValue();
		  
		  return currval;
   }
}
