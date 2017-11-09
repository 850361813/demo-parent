/*
 * Copyright (C) 2017 Baidu, Inc. All Rights Reserved.
 */
package com.eden.demo.tools;

import com.google.common.base.Joiner;

/**
 * Create by zhaoxianghui on 2017/11/9.
 */
public class ConcatString {

    private static String data = "1448599525869294626\n" + "1448595024743453670\n" + "1448492770162035729\n"
                                         + "1448487650560920766\n" + "1448487169524558985\n" + "1448487169524558984\n"
                                         + "1448484936141532314\n" + "1423417411057982398\n" + "1423417411057982397\n"
                                         + "1423374014708407897\n" + "1423371231569583350\n" + "1423371231569583349\n"
                                         + "1423371231569583348\n" + "1423371231569583347\n" + "1423145522448167344\n"
                                         + "1423145522448167318\n" + "1423080857420511440\n" + "1423079723549118705\n"
                                         + "1423079620469897833\n" + "1423079620469897832\n" + "1423077387086835716\n"
                                         + "1423072817241607707\n" + "1423061272369464613\n" + "1423057217920271760\n"
                                         + "1423055396854113218\n" + "1423053026032092520\n" + "1423052888593122844\n"
                                         + "1409827481697749150\n" + "1409812397772434880\n" + "1409812157254258030\n"
                                         + "1409811160821829098\n" + "1409811160821829097\n" + "1409807278171287034\n"
                                         + "1409806865854401947\n" + "1409798069761363357\n" + "1409798069761363356\n"
                                         + "1371514586710647799\n" + "1371514483631436276\n" + "1371499399706265061\n"
                                         + "1371499365346526365\n" + "1371498334554358476\n" + "1371497063244030406\n"
                                         + "1371496341689500632\n" + "1371496272970008063\n" + "1371493043154568081\n"
                                         + "1371493008794829259\n" + "1371492252880569138\n" + "1371492184161096206\n"
                                         + "1371490122576773720\n" + "1371489985137796085\n" + "1371489882058584388\n"
                                         + "1371489744619622752\n" + "1371480467490237103\n" + "1371477718711117475\n"
                                         + "1371477684351376503\n" + "1371477684351376487\n" + "1371477649991634264\n"
                                         + "1371477649991634263\n" + "1371477512552672001\n" + "1371475313529380212\n"
                                         + "1371475279169644325\n" + "1371475279169644290\n" + "1371475038651460086\n"
                                         + "1371465452284387877\n" + "1371465452284387848";

    public static void main(String[] args) {
        String[] strings = data.split("\n");
        Joiner joiner = Joiner.on("','");
        System.out.println("('"+joiner.join(strings) + "')");
    }
}
