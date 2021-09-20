IFS=","
while read A B C D E F G H I; do
	echo "example_""$E""_""$F""_""$G""_""$H" #輸出注音和音標號碼
	if [ $loop -eq 0 ] && [ $loop2 -eq 0 ] && [ $loop3 -eq 0 ] #如果注音均為空音就跳過
	then
		continue
	fi
	#check=0 #記錄檔案是否為空音檔
	`ffmpeg -i "example_""$E""_""$F""_""$G""_""$H"".ts" "example_""$E""_""$F""_""$G""_""$H"".ogg"`
done < "pinyinfinal.csv"

echo "complete"

#echo `trans --help`