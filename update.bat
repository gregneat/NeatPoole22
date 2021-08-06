@echo off
git fetch origin main
git reset --hard FETCH_HEAD
echo Your textbook is now up to date!
pause
