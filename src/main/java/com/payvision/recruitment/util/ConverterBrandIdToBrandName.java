package com.payvision.recruitment.util;

import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ConverterBrandIdToBrandName {
    private static Map<Integer, String> brandsMap = Stream.of(new Object[][] {
            {1010,"VISA"},
            {1011,"Visa Electron"},
            {1012,"Dankort"},
            {1013,"Visa Debit"},
            {1014,"Visa-Carte Bancaire"},
            {1015,"VPAY"},
            {1017,"Delta"},
            {1020,"MasterCard"},
            {1023,"Mastercard Debit"},
            {1024,"Mastercard-Carte Bancaire"},
            {1030,"American Express"},
            {1040,"Discover"},
            {1050,"Maestro"},
            {1060,"Diners Club"},
            {1070,"Carte Bancaire"},
            {1080,"CartaSi (VISA, Mastercard)"},
            {1090,"JCB"},
            {1100,"Argencard"},
            {1101,"Cabal"},
            {1102,"Elo"},
            {1103,"Hipercard"},
            {1104,"Presto"},
            {1106,"Tarjeta Naranja"},
            {1109,"Bonus (VISA)"},
            {1111,"Cartebleue (VISA, Mastercard)"},
            {1113,"MercadoLivre"},
            {1114,"Nativa"},
            {1117,"Tarjeta Shopping"},
            {1118,"World"},
            {1119,"Cencosud"},
            {1210,"BCMC"}
    }).collect(Collectors.toMap(data -> (Integer) data[0], data -> (String) data[1]));;

    public static String convertBrandIdToBrandName(Integer brandId) {

        String brandName = brandsMap.get(brandId);

        if(Optional.ofNullable(brandName).isPresent()) {
            return brandName;
        } else {
            return "Other";
        }
    }
}
