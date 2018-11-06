package com.example.mathe.a05_controle_abastecimento;

import android.content.Context;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

public class abastecimentoDAO {
    private static ArrayList<abastecimentoDados> CACHE = new ArrayList<abastecimentoDados>();

    private static final String nomeArquivo = "autonomia2.txt";

    public static boolean salvarNovo (Context cont, abastecimentoDados aSerSalva)
    {
        CACHE.add(aSerSalva);

        String salvar = "";

        salvar += aSerSalva.getData() + ";";
        salvar += aSerSalva.getPosto() + ";";
        salvar += aSerSalva.getKm() + ";";
        salvar += aSerSalva.getLitragem() + "\n";

        File refArquivo = new File (cont.getFilesDir().getPath() + nomeArquivo);

        try
        {
            FileWriter escritor = new FileWriter(refArquivo, true);
            escritor.write (salvar);
            escritor.close();
            return true;
        }catch (IOException e)
        {
            e.printStackTrace();
            return false;
        }

    }

    public static ArrayList<abastecimentoDados> getLista (Context cont)
    {
        CACHE = new ArrayList<>();

        File refArquivo = new File (cont.getFilesDir().getPath() + nomeArquivo);

        try
        {
            FileReader leitor = new FileReader(refArquivo);
            BufferedReader leitorDeLinha = new BufferedReader(leitor);

            String linhaAbastecimento = null;

            while ((linhaAbastecimento = leitorDeLinha.readLine()) != null)
            {
                String[] partesDaLinha = linhaAbastecimento.split(";");
                abastecimentoDados utilizadoAgora = new abastecimentoDados();
                utilizadoAgora.setKm(Double.parseDouble(partesDaLinha[0]));
                utilizadoAgora.setLitragem(Double.parseDouble(partesDaLinha[1]));
                utilizadoAgora.setData(partesDaLinha[2]);
                utilizadoAgora.setPosto(partesDaLinha[3]);

                CACHE.add(utilizadoAgora);
            }

        }catch (IOException e)
        {
            e.printStackTrace();
        }

        return CACHE;
    }
}
