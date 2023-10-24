package PRIVATE;

import DTO.PesquisaDTO;
import java.awt.Component;

public interface EventClick {
    public void itemClick(PesquisaDTO objpesquisadto);
    public void itemRemove(Component com, PesquisaDTO objpesquisadto);
}
