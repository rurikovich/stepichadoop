package javaBaseCourse.task3_5;


/**
 * Created by User on 06.01.2017.
 */
public class AsciiCharSequence implements CharSequence {
    private byte[] bArr;

    public AsciiCharSequence(byte[] bArr) {
        this.bArr = bArr;
    }

    public int length() {
        return bArr.length;
    }

    public char charAt(int index) {
        return (char) bArr[index];
    }

    public CharSequence subSequence(int start, int end) {
        return new AsciiCharSequence(java.util.Arrays.copyOfRange(bArr, start, end));

    }

    public String toString() {
        StringBuilder res = new StringBuilder();
        for (byte b : bArr) {
            res.append((char) b);
        }
        return res.toString();
    }
}