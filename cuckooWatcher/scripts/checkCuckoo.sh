#!/bin/bash
####################################################
#######@reboot sh /root/chceckCuckoo.sh#############
####################################################
sudo ifdown vboxnet0
sudo ifup vboxnet0
####################################################
echo "[*] virtualbox Hostonly adapter is running"
####################################################
if lsof -Pi :2042 -sTCP:LISTEN -t >/dev/null ; then
echo "[*] cuckoo sandbox is running"
####################################################
if lsof -Pi :8000 -sTCP:LISTEN -t >/dev/null ; then
echo "[*] cockoo web is running"
else
echo "[*] cuckoo web isn't running"
sudo runuser -l  ubuntu -c 'cuckoo web runserver &'
echo "[*] cuckoo web is running now"
fi
#####################################################
else
echo "[*] cuckoo sandbox isn't running"
sudo runuser -l  ubuntu -c 'cuckoo -d &'
echo "[*] cuckoo sandbox is running now"
#####################################################
if lsof -Pi :8000 -sTCP:LISTEN -t >/dev/null ; then
echo "[*] cockoo web is running"
else
echo "[*] cuckoo web isn't running"
sudo runuser -l  ubuntu -c 'cuckoo web runserver &'
echo "[*] cuckoo web is running now"
fi
fi
#######################################################