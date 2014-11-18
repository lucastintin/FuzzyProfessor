/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author lucasamiune
 */
public class Brain {
    private float miPontCedo;
    private float miPontMedio;
    private float miPontAtrasado;
    private float miFreqPouca;
    private float miFreqMuita;
    private float miDidaticaBoa;
    private float miDidaticaRuim;
    private float miExerPouco;
    private float miExerRegular;
    private float miExerMuito;
    private float miCoesPouca;
    private float miCoesMuita;
    private float miAcesPouca;
    private float miAcesMuita;
    //Pertinencia de Qualidade
    private float miQualRuim;
    private float miQualBoa;
    
    private float[] infRegra = new float[30];
    private float[] miMenor = new float[30];

    public Brain() {
    }
    
    private float calcularMiPontCedo(int pPontualidade){
        float resultado = 0;
        
        resultado = (float) (15-pPontualidade)/15;
        
        return resultado;
    }
    
    private float calcularMiPontMedio(int pPontualidade){
        float resultado = 0;
        
        if (pPontualidade <=15) {
            resultado = (float) (pPontualidade)/15;
        }
        if ((pPontualidade > 15) && (pPontualidade <30)) {
            resultado = 1;
        }
        if (pPontualidade >=30){
            resultado = (float) (45-pPontualidade)/15;
        }
        
        return resultado;
    }
    
    private float calcularMiPontAtrasado(int pPontualidade) {
        float resultado = 0;
        
        if (pPontualidade <20) {
            resultado = 0;
        }
        if ((pPontualidade >=20) && (pPontualidade < 45)){
            resultado = (float) (pPontualidade-20)/25;
        }
        if (pPontualidade >=45){
            resultado = 1;
        }
        
        return resultado;
    }
    
    private float calcularMiFreqPouca(int pFrequencia) {
        float resultado = 0;
        
        if (pFrequencia <= 8) {
            resultado = 1;
        }
        if ((pFrequencia > 8) && (pFrequencia <=30)){
            resultado = (float) (30-pFrequencia)/22;
        }
        if (pFrequencia >30){
            resultado = 0;
        }
        
        return resultado;
    }
    
    private float calcularMiFreqMuita(int pFrequencia) {
        float resultado = 0;
        
        if (pFrequencia ==0) {
            resultado = 0;
        }
        if ((pFrequencia>0) && (pFrequencia<= 23)){
            resultado = (float) (pFrequencia)/23;
        }
        if (pFrequencia >23) {
            resultado = 1;
        }
        
        return resultado;
    }
    
    private float calcularMiDidaticaBoa(int pDidatica){
        float resultado = 0;
        if (pDidatica == 1) {
            resultado = 1;
        } 
        if (pDidatica == 2) {
            resultado = 0;
        }
        return resultado;
    }
    
   private float calcularMiDidaticaRuim(int pDidatica) {
       float resultado = 0;
       
       if (pDidatica == 1) {
           resultado = 0;
       } 
       if (pDidatica == 2) {
           resultado = 1;
       }
       
       return resultado;
   }
    
   private float calcularMiExerPouco(int pExercicio){
       float resultado = 0;
       
       if (pExercicio <= 10) {
           resultado = 1;
       } 
       if ((pExercicio> 10) && (pExercicio<=30)){
           resultado = (float) (30-pExercicio)/20;
       }
       if (pExercicio>30) {
           resultado = 0;
       }
       
       return resultado;
   }
   
   private float calcularMiExerRegular(int pExercicio){
       float resultado = 0;
       
       if (pExercicio <30){
           resultado = (float) pExercicio/30;
       }
       if ((pExercicio>=30) && (pExercicio<=60)) {
           resultado = 1;
       }
       if (pExercicio>60) {
           resultado = (float) (90-pExercicio)/30;
       }
        
       return resultado;
   }
   
   private float calcularMiExerMuito(int pExercicio) {
       float resultado = 0;
       
       if (pExercicio <30) {
           resultado = 0;
       }
       if ((pExercicio>=30) && (pExercicio<=60)){
           resultado = (float) (pExercicio-30)/30;
       } 
       if (pExercicio>60) {
           resultado = 1;
       }
        
       return resultado;
   }
   
   //coesao
   private float calcularMiCoesPouca(int pCoesao) {
       float resultado = 0;
       
       if (pCoesao  <=5){
           resultado = 1;
       }
       if ((pCoesao>5) && (pCoesao <=7)) {
           resultado = (float) (7-pCoesao)/2;
       }
       if (pCoesao>7){
           resultado = 1;
       }
        
       return resultado;
   }
   
   private float calcularMiCoesMuita(int pCoesao) {
       float resultado = 0;
       
       if (pCoesao<=3){
           resultado = 0;
       }
       if ((pCoesao>3) && (pCoesao<=5)){
           resultado = (float) (pCoesao-3)/2;
       }
       if (pCoesao>5) {
           resultado = 1;
       }        
        
       return resultado;
   }
   
   //acessibilidade
   private float calcularMiAcesPouca(int pAcesso){
       float resultado = 0;
        
       if (pAcesso <=1){
           resultado = 1;
       } 
       if ((pAcesso>1) && (pAcesso<=3)){
           resultado = (float) (3-pAcesso)/2;
       }
       if (pAcesso >3){
           resultado =0;
       }
        
       return resultado;
   }
   
   private float calcularMiAcesMuita(int pAcesso){
       float resultado = 0;
       
       if (pAcesso<=3){
           resultado = 0;
       }
       if ((pAcesso>3) && (pAcesso<=5)){
           resultado = (float) (pAcesso-3)/2;
       }
       if (pAcesso>5){
           resultado = 1;
       }
       
       return resultado;
   }
   
   public void fuzzificar(int pPontualidade, int pFrequencia, int pDidatica, int pExercicio, int pCoesao, int pAcesso) {
       this.miPontCedo = calcularMiPontCedo(pPontualidade);
       this.miPontMedio = calcularMiPontMedio(pPontualidade);
       this.miPontAtrasado = calcularMiPontAtrasado(pPontualidade);
       this.miFreqPouca = calcularMiFreqPouca(pFrequencia);
       this.miFreqMuita = calcularMiFreqMuita(pFrequencia);
       this.miDidaticaRuim = calcularMiDidaticaRuim(pDidatica);
       this.miDidaticaBoa = calcularMiDidaticaBoa(pDidatica);
       this.miExerPouco = calcularMiExerPouco(pExercicio);
       this.miExerRegular = calcularMiExerRegular(pExercicio);
       this.miExerMuito = calcularMiExerMuito(pExercicio);
       this.miCoesPouca = calcularMiCoesPouca(pCoesao);
       this.miCoesMuita = calcularMiCoesMuita(pCoesao);
       this.miAcesPouca = calcularMiAcesPouca(pAcesso);
       this.miAcesMuita = calcularMiAcesMuita(pAcesso);
   }
   
   private float calcularMiQualRuim(float pX){
       float resultado = 0;
       
       if (pX == 1) {
           resultado = 3;
       } else {
           resultado = (float) 5-(2*pX);
       }
       
       return resultado;
   }
   
   private float calcularMiQualBoa(float pX){
       float resultado = 0;
        
       if (pX == 0){
           resultado = 5;
       } 
       if ((pX > 0) && (pX < 1)) {
           resultado  = (float) (2*pX)+5;
       }
       if (pX == 1){
           resultado = 7;
       }
      
       return resultado;
   }
   
   private float lukazieviesk(float param1, float param2, float param3){
       float menor;
       
       menor = Math.min(param1, param2);
       menor = Math.min(param3, menor);
       
       return menor;
   }
   
   public float desfuzzificar(){
       float saida = 0;
       float somatorio1= 0;
       float somatorio2= 0;
       
       //Usar a função de Lukazieviski para calcular a qualidade
       miMenor[0] = lukazieviesk(miPontCedo, miFreqMuita, miDidaticaBoa);
       infRegra[0] = calcularMiQualBoa(miMenor[0]);
       
       miMenor[1] = lukazieviesk(miPontCedo, miFreqMuita, miExerRegular);
       infRegra[1] = calcularMiQualBoa(miMenor[1]);
       
       miMenor[2] = lukazieviesk(miPontCedo, miFreqMuita, miExerMuito);
       infRegra[2] = calcularMiQualBoa(miMenor[2]);
       
       miMenor[3] = lukazieviesk(miPontCedo, miFreqMuita, miCoesMuita);
       infRegra[3] = calcularMiQualBoa(miMenor[3]);
       
       miMenor[4] = lukazieviesk(miPontCedo, miFreqMuita, miAcesMuita);
       infRegra[4] = calcularMiQualBoa(miMenor[4]);
       
       miMenor[5] = lukazieviesk(miPontMedio, miFreqMuita, miDidaticaBoa);
       infRegra[5] = calcularMiQualBoa(miMenor[5]);
       
       miMenor[6] = lukazieviesk(miDidaticaBoa, miExerRegular, miCoesMuita);
       infRegra[6] = calcularMiQualBoa(miMenor[6]);
       
       miMenor[7] = lukazieviesk(miPontMedio, miDidaticaBoa, miExerMuito);
       infRegra[7] = calcularMiQualBoa(miMenor[7]);
       
       miMenor[8] = lukazieviesk(miPontMedio, miDidaticaBoa, miCoesMuita);
       infRegra[8] = calcularMiQualBoa(miMenor[8]);
       
       miMenor[9] = lukazieviesk(miPontMedio, miDidaticaBoa, miAcesMuita);
       infRegra[9] = calcularMiQualBoa(miMenor[9]);
       
       miMenor[10] = lukazieviesk(miPontMedio, miExerRegular, miCoesMuita);
       infRegra[10] = calcularMiQualBoa(miMenor[10]);
      
       miMenor[11] = lukazieviesk(miPontMedio, miExerRegular, miAcesMuita);
       infRegra[11] = calcularMiQualBoa(miMenor[11]);
      
       miMenor[12] = lukazieviesk(miPontMedio, miExerMuito, miAcesMuita);
       infRegra[12] = calcularMiQualBoa(miMenor[12]);
       
       miMenor[13] = lukazieviesk(miFreqMuita, miCoesMuita, miAcesMuita);
       infRegra[13] = calcularMiQualBoa(miMenor[13]);
       
       miMenor[14] = lukazieviesk(miExerMuito, miCoesMuita, miAcesMuita);
       infRegra[14] = calcularMiQualBoa(miMenor[14]);
      
      //Agora os ruins
       miMenor[15] = lukazieviesk(miPontMedio, miFreqPouca, miDidaticaRuim);
       infRegra[15] = calcularMiQualRuim(miMenor[15]);
       
       miMenor[16] = lukazieviesk(miPontMedio, miDidaticaRuim, miExerRegular);
       infRegra[16] = calcularMiQualRuim(miMenor[16]);
       
       miMenor[17] = lukazieviesk(miPontMedio, miDidaticaRuim, miExerPouco);
       infRegra[17] = calcularMiQualRuim(miMenor[17]);
       
       miMenor[18] = lukazieviesk(miPontMedio, miDidaticaRuim, miCoesPouca);
       infRegra[18] = calcularMiQualRuim(miMenor[18]);
       
       miMenor[19] = lukazieviesk(miPontMedio, miDidaticaRuim, miAcesPouca);
       infRegra[19] = calcularMiQualRuim(miMenor[19]);
       
       miMenor[20] = lukazieviesk(miPontAtrasado, miFreqPouca, miDidaticaRuim);
       infRegra[20] = calcularMiQualRuim(miMenor[20]);
       
       miMenor[21] = lukazieviesk(miDidaticaRuim, miCoesPouca, miAcesPouca);
       infRegra[21] = calcularMiQualRuim(miMenor[21]);
       
       miMenor[22] = lukazieviesk(miExerPouco, miCoesPouca, miAcesPouca);
       infRegra[22] = calcularMiQualRuim(miMenor[22]);
       
       miMenor[23] = lukazieviesk(miPontAtrasado, miFreqPouca, miAcesPouca);
       infRegra[23] = calcularMiQualRuim(miMenor[23]);
       
       miMenor[24] = lukazieviesk(miPontAtrasado, miFreqPouca, miExerPouco);
       infRegra[24] = calcularMiQualRuim(miMenor[24]);
       
       miMenor[25] = lukazieviesk(miExerRegular, miCoesPouca, miAcesPouca);
       infRegra[25] = calcularMiQualRuim(miMenor[25]);
       
       miMenor[26] = lukazieviesk(miPontAtrasado, miFreqPouca, miExerPouco);
       infRegra[26] = calcularMiQualRuim(miMenor[26]);
       
       miMenor[27] = lukazieviesk(miFreqPouca, miCoesPouca, miAcesPouca);
       infRegra[27] = calcularMiQualRuim(miMenor[27]);
       
       miMenor[28] = lukazieviesk(miFreqPouca, miExerRegular, miAcesPouca);
       infRegra[28] = calcularMiQualRuim(miMenor[28]);
       
       miMenor[29] = lukazieviesk(miPontAtrasado, miCoesPouca, miAcesPouca);
       infRegra[29] = calcularMiQualRuim(miMenor[29]);
        
       for (int x=0; x<=29; x++){
           somatorio1 = somatorio1 + (infRegra[x]*miMenor[x]);
           somatorio2 = somatorio2 + miMenor[x];
       }
       
       saida = somatorio1/somatorio2;
       
       //vamos dizer que eu faça essa mudança no arquivo
       
       return saida;
   }
  
    
}
