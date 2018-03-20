package com.totvs.agro.coffeandcode.java8.exemplos;

import java.math.BigDecimal;
import java.util.Collection;

import com.google.common.base.Function;
import com.totvs.agro.coffeandcode.java8.dao.TalhaoDAO;
import com.totvs.agro.coffeandcode.java8.model.TalhaoVO;

public class ExemplosCollections {

    static Function<TalhaoVO, Long> FUNCTION_ID_TALHAO_SEM_LAMBDA = new Function<TalhaoVO, Long>() {
        public Long apply(TalhaoVO upn3) {
            return upn3.getId();
        }
    };
    
    static Function<TalhaoVO, Long> FUNCTION_ID_TALHAO_LAMBDA = talhao -> talhao.getId();
    
    static Function<TalhaoVO, Long> FUNCTION_ID_TALHAO = TalhaoVO::getId;
    
    public static void insertTalhoesLambda(Collection<TalhaoVO> talhoes) {
    	TalhaoDAO talhaoDAO = new TalhaoDAO();
    	//iteração utilizando lambda
    	talhoes.forEach(t -> talhaoDAO.insert(t));
    }
    
    public static void insertTalhoesMethodReference(Collection<TalhaoVO> talhoes) {
    	TalhaoDAO talhaoDAO = new TalhaoDAO();
    	//utilizando method reference
    	talhoes.forEach(talhaoDAO::insert);
    }
    
    public static void insertTalhoesSemAreaDisponivelLambda(Collection<TalhaoVO> talhoes) {
    	talhoes.removeIf(t -> t.getArea().compareTo(BigDecimal.ZERO) == 0);
    	TalhaoDAO talhaoDAO = new TalhaoDAO();
    	talhoes.forEach(talhaoDAO::insert);
    }
    
    public static void insertTalhoesSemAreaDisponivelMethodReference(Collection<TalhaoVO> talhoes) {
    	//remove talhões sem área disponível
    	talhoes.removeIf(TalhaoVO::isSemAreaDisponivel);
    	TalhaoDAO talhaoDAO = new TalhaoDAO();
    	//insere no banco de dados os talhões que sobrarams
    	talhoes.forEach(talhaoDAO::insert);
    }
    
}
