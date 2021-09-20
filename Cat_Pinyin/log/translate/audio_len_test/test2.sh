test=$(date +"%s")

echo $test

test2=$(date +"%s")

echo $test2


test3=1
test3=`expr $test3 + 1`
echo $test3

test3=3
echo $test3

echo "reload" `expr $test2 - $test3`