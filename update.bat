@echo off
git fetch main master
git reset --hard FETCH_HEAD
echo Your textbook is now up to date!
pause
