map<char,int>c2b;
map<int,char>b2c;
auto Compressor(const string& s){
    int len = s.size();
    unsigned char* bytes = new unsigned char [(len+3)/4];
    memset(bytes,0,(len+3)/4);
    int i = 0;
    while(i<len){
        int block_index = i/4;
        bytes[block_index] |= (c2b[s[i]]<<((3-(i%4))*2));
        i++;
    }
    return tuple{bytes,(len+3)/4};
}
string decompress(int origin_length,unsigned char* bytes){
    string dna;
    for(int i=0;i<origin_length;i++){
        int block_index = i/4;
        //依旧需要先计算当前位置属于哪一个块
        int code =((bytes[block_index]>>((3-(i%4))*2)) & 0x03);
        char cur = b2c[code];
        dna += cur;
    }
    return dna;
}
int main(){
    c2b.insert({'T',0x00});
    c2b.insert({'A',0x01});
    c2b.insert({'G',0x02});
    c2b.insert({'C',0x03});
    
    b2c.insert({0x00,'T'});
    b2c.insert({0x01,'A'});
    b2c.insert({0x02,'G'});
    b2c.insert({0x03,'C'});
    
    string DNA = "TAGGGATTAACCGTTATATATATATAGCCATGGTGGATCGATTATATAAGCCGTTATATATATATAGCCATGGATCGATTATA";
    int origin = DNA.size();
    //原始数据的长度
    auto [bytes,compressed] = Compressor(DNA);
    //字节数组和压缩后的数据长度
    string decompressed_DNA = decompress(origin,bytes);
    if(decompressed_DNA==DNA){
        cout<<"压缩解压正确 !"<<endl;
        cout<<"压缩比为："<<std::fixed<<std::setprecision(4)<<compressed*8/(origin*sizeof(char)*8.0);
    }else{
        cout<<"压缩解压错误 !"<<endl;
    }
    return 0;
}