package Lab_1;

import java.util.*;

public class DNACompressor {
    // 核苷酸到二进制的映射
    private static final Map<Character, Integer> nucleotideToBits = Map.of(
            'A', 0b00,
            'C', 0b01,
            'G', 0b10,
            'T', 0b11
    );

    // 二进制到核苷酸的映射
    private static final char[] bitsToNucleotide = {'A', 'C', 'G', 'T'};

    public static byte[] compress(String s) {
        int len = s.length();
        byte[] compressed = new byte[(len + 3) / 4];
        // 4 个核苷酸占 1 个字节

        for (int i = 0; i < len; i++) {
            int index = i / 4;
            // 计算当前字符对应的字节索引
            int shift = (3 - (i % 4)) * 2;
            // 计算当前字符在该字节中的偏移量
            compressed[index] |= (nucleotideToBits.get(s.charAt(i)) << shift);
            // 将 2 位数据写入对应位置
        }
        return compressed;
    }

    public static String decompress(byte[] compressed, int originalLength) {
        StringBuilder sb = new StringBuilder(originalLength);

        for (int i = 0; i < originalLength; i++) {
            int index = i / 4;// 计算当前字符所在的字节索引
            int shift = (3 - (i % 4)) * 2; // 计算当前字符在该字节中的偏移量
            int bits = (compressed[index] >> shift) & 0b11; // 取出 2 位数据
            sb.append(bitsToNucleotide[bits]); // 通过映射表转换回核苷酸字符
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        String dnaSequence = "TAGGGATTAACCGTTATATATATATAGCCATGGATGGATCGATTATATAACCGTTATATATATATAGCCATGGATCGATTATA";
        byte[] compressedData = compress(dnaSequence);
        String decompressedData = decompress(compressedData, dnaSequence.length());

        System.out.println("原始 DNA 序列长度: " + dnaSequence.length() * 16 + " bit");
        System.out.println("压缩后长度: " + compressedData.length * 8 + " bit");
        System.out.println("压缩比: " + (100.0 * compressedData.length * 8 / (dnaSequence.length() * 16)) + "%");
        System.out.println("解压是否正确: " + dnaSequence.equals(decompressedData));
        //压缩比越小越好，因为这意味着压缩后的数据占用更少的存储空间
    }
}
