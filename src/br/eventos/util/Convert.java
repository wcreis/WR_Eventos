/**
 * 
 */
package br.eventos.util;

/**
 * @author Wesley
 *
 */
public abstract class Convert {

	/**
	 * Converte uma data do tipo SQL date para o TIpo Util Date.
	 * @param dateSql
	 * @return
	 */
	public static java.util.Date sqlToUtilDate(java.sql.Date dateSql){
		return new java.util.Date(dateSql.getTime());
	}
	
	/**
	 * Converte uma data do Tipo Util Date para o Tipo SQL Date
	 * @param dateUtil
	 * @return
	 */
	public static java.sql.Date utilToSqlDate(java.util.Date dateUtil) {
		if(dateUtil.getTime()==0){
			return new java.sql.Date(System.currentTimeMillis());
		}else{
			return new java.sql.Date(dateUtil.getTime());
		}
	}

}
