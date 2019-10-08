package signos.cursoandroid.com.qrcodeapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

public class MainActivity extends AppCompatActivity {

    String [] codigosQR = { "41190201525323000161650410000970541340826502","41190401525323001648650020002771319233872360",
                            "41190401525323001648650020002790419326667988","41190401525323001648650020002790609764614767",
                            "41190401525323001648650020002819399742379288","41190501525323001648650020002900419355150076",
                            "41190281900227001590651330000891619000059688","41190181900227000861651330000790329000790330",
                            "41190281900227001590651230001663879001658686","41190281900227001590651230001664049001658859",
                            "41190281900227001590651310001417429000141461","41190281900227001590651310001417659000141695",
                            "41190181900227001086651140000415109000415115","41190281900227001590651330000896789000064856",
                            "41190281900227001590651330000896969000065036","41190281900227001590651410000863269000863275",
                            "41190281900227001590651410000863329000863337","41190281900227001590651330000900399000068462",
                            "41190281900227001590651210001691689001686102","41190281900227000861651220001325849001325853",
                            "41190281900227000861651240001097169001097170","41190381900227001590651320000977189000977192",
                            "41190381900227000861651220001376139001376148","41190381900227001590651330000955769000123835",
                            "41190381900227001590651330000962189000130259","41190381900227001086651190000809069000809073",
                            "41190381900227001590651330000964189000132252","41190481900227001590651200002172619002166375",
                            "41190481900227001590651200002173949002167700","41190581900227001752651290000836789000520330",
                            "41190581900227000195651290001545709001545710","41190581900227000195651290001545909001545918",
                            "41190581900227000195651290001545949001545950","41190581900227000195651290001551539001551542",
                            "41190581900227000195651290001551549001551558","41190581900227000861651340000870749000092093",
                            "41190581900227000861651280001095049001095059","41190581900227000195651290001558879001558888",
                            "41190230308304000181650040000213279000213279","41190230308304000181650040000215659000215656",
                            "41190230308304000181650030000150689000150689","41190230308304000181650030000150689000150689",
                            "41190230308304000181650040000222279000222277","41190230308304000181650040000222379000222370",
                            "41190230308304000181650040000224679000224675","41190230308304000181650050000046479000046471",
                            "41190330308304000181650030000157189000157187","41190330308304000181650030000159759000159756",
                            "41190330308304000181650030000159809000159802","41190330308304000181650030000160469000160464",
                            "41190330308304000181650030000161099000161098","41190330308304000181650030000167489000167488",
                            "41190330308304000181650040000241359000241351","41190330308304000181650040000241539000241538",
                            "41190330308304000181650040000245059000245058","41190330308304000181650040000246279000246278",
                            "41190330308304000181650040000246329000246324","41190330308304000181650040000254439000254430",
                            "41190330308304000181650040000263449000263443","41190330308304000181650050000047739000047736",
                            "41190330308304000181650050000047921000047922","41190330308304000181650050000050609000050603",
                            "41190330308304000181650050000050639000050630","41190430308304000181650040000270519000270519",
                            "41190430308304000181650050000079699000079692","41190530308304000181650050000097509000097500",
                            "41190530308304000181650050000106259000106252","41190530308304000181650050000106279000106273",
                            "41190530308304000181650050000108059000108059","41190202133453000200651120001695559001695556",
                            "41190202133453000200651130001557789001557790","41190102133453000200651130001503329001503331",
                            "41190202133453000200651130001557809001557810","41190202133453000200651130001557729001557737",
                            "41190202133453000200651140001236059001236068","41190102133453000200651110000807759000807765",
                            "41190202133453000200651110000821789000821794","41190202133453000200651130001562669001562676",
                            "41190102133453000200651130001540609001540616","41190202133453000200651130001571969001571975",
                            "41190202133453000200651130001572399001572407","41190202133453000200651110000828219000828220",
                            "41190202133453000200651110000830909000830916","41190202133453000200651120001706089001706084",
                            "41190202133453000200651130001578969001578978","41190202133453000200651140001258789001258793",
                            "41190202133453000200651110000831849000831856","41190202133453000200651120001716599001716598",
                            "41190202133453000200651120001718639001718632","41190202133453000200651130001582019001582027",
                            "41190202133453000200651130001582819001582826","41190202133453000200651140001259929001259930",
                            "41190202133453000200651130001595409001595411","41190202133453000200651120001734959001734957",
                            "41190202133453000200651120001740759001740752","41190202133453000200651140001283439001283446",
                            "41190302133453000200651130001610719001610720","41190302133453000200651130001612189001612190",
                            "41190302133453000200651130001617019001617028","41190302133453000200651120001759709001759705",
                            "41190302133453000200651130001617029001617033","41190202133453000200651120001726519001726514",
                            "41190302133453000200651120001748149001748143","41190302133453000200651120001779039001779036",
                            "41190302133453000200651130001626809001626810","41190302133453000200651130001630909001630912",
                            "41190302133453000200651140001309639001309646","41190302133453000200651140001311139001311143",
                            "41190302133453000200651140001319369001319371","41190302133453000200651140001319399001319403",
                            "41190302133453000200651110000866639000866646","41190302133453000200651110000871389000871393",
                            "41190302133453000200651130001636329001636332","41190302133453000200651130001640779001640783",
                            "41190302133453000200651130001650059001650067","41190302133453000200651130001650849001650850",
                            "41190302133453000200651130001657209001657210","41190302133453000200651140001337839001337840",
                            "41190402133453000200651130001660799001660803","41190402133453000200651140001344649001344656",
                            "41190402133453000200651110000895769000895778","41190402133453000200651110000897029000897034",
                            "41190402133453000200651140001381949001381951","41190402133453000200651140001381959001381967",
                            "41190502133453000200651140001394999001395007","41190502133453000200651120001902139001902130",
                            "41190502133453000200651140001403229001403230","41190502133453000200651140001405559001405561",
                            "41190502133453000200651140001405919001405924","41190502133453000200651110000925669000925676",
                            "41190502133453000200651120001916229001916226","41190502133453000200651140001419469001419470",
                            "41190502133453000200651140001419569001419574","41190502133453000200651120001916309001916309",
                            "41190502133453000200651120001923329001923324","41190502133453000200651140001427839001427845",};

    private TextView textoResultado;
    private ImageView iconeVerde;
    private EditText campoScaner;
    private Button botaoVerificar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    try {

        botaoVerificar = (Button) findViewById(R.id.botaoVerificarId);
        campoScaner = (EditText) findViewById(R.id.campoScanerId);
        iconeVerde = (ImageView) findViewById(R.id.iconeVerdeId);
        textoResultado = (TextView) findViewById(R.id.textoResultadoId);
        final Button botaoScan = (Button) findViewById(R.id.botaoId);
        final Activity activity = this;
        campoScaner.requestFocus();


        //Botao Verificar
        botaoVerificar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(campoScaner.getText().toString().equals("") || campoScaner.getText().toString().length() < 45  ){
                    alert("CAMPO VAZIO ou FORMATO INCORRETO");
                    textoResultado.setText("");
                    iconeVerde.setImageDrawable(null);
                }else {

                    String textoQrValidar = campoScaner.getText().toString().substring(
                            campoScaner.getText().toString().indexOf("=") + 1);
                    final String textoQrValidarFinal = textoQrValidar.substring(0, 44);

                    Boolean desligaFor = false;
                    for (int aCondigo = 0; aCondigo < codigosQR.length && desligaFor == false; aCondigo++) {
                        if (textoQrValidarFinal.equals(codigosQR[aCondigo])) {
                            desligaFor = true;

                        } else {

                            desligaFor = false;
                        }

                    }

                    if (desligaFor == true) {
                        alert("CODIGO CORRETO: " + textoQrValidarFinal);
                        iconeVerde.setImageResource(R.drawable.iconeverde);
                        textoResultado.setText("CODIGO CORRETO " + textoQrValidarFinal);
                    } else if (desligaFor == false) {
                        alert("CODIGO INCORRETO");
                        textoResultado.setText("CODIGO INCORRETO" + textoQrValidarFinal);
                        iconeVerde.setImageResource(R.drawable.iconevermelho);
                    }

                }

                campoScaner.setText("");
                campoScaner.setFocusable(true);
                campoScaner.requestFocus();
            }
        });



        // Botao Scan
        botaoScan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                IntentIntegrator integrator = new IntentIntegrator(activity);
                integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE_TYPES);
                integrator.setPrompt("Aguardando QRCode");
                integrator.setCameraId(0);
                integrator.initiateScan();
                textoResultado.setText("");
                iconeVerde.setImageDrawable(null);

            }
        });
        campoScaner.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(!hasFocus){
                    campoScaner.setFocusable(false);
                }

            }
        });

    }catch (Exception e){
        e.printStackTrace();
    }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode,resultCode,data);
        if(result != null){

            if (result.getContents() != null){


                String testeResultado = result.getContents().substring(result.getContents().indexOf("=")+1);
                String testeResultado2 = testeResultado.substring(0,44);
                Boolean desligaFor = false;
                    for (int tamanhoArray = 0; tamanhoArray < codigosQR.length && desligaFor == false; tamanhoArray++) {
                        if (testeResultado2.equals(codigosQR[tamanhoArray])) {
                            desligaFor = true;

                        } else {
                            desligaFor = false;

                        }

                    }
                    if (desligaFor == true){
                        alert("CODIGO CORRETO: " + testeResultado2);
                        iconeVerde.setImageResource(R.drawable.iconeverde);
                        textoResultado.setText("CODIGO CORRETO " + testeResultado2);
                    }else {
                        alert("CODIGO INCORRETO: " + testeResultado2);
                        iconeVerde.setImageResource(R.drawable.iconevermelho);
                        textoResultado.setText("CODIGO INCORRETO " + testeResultado2);
                    }

                }else {
                alert ("Scaner Cancelado");
            }

        }else {
            super.onActivityResult(requestCode, resultCode, data);

        }}

        private void alert (String msg){
        Toast.makeText(MainActivity.this, msg, Toast.LENGTH_LONG).show();
        }



}

