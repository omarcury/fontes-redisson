cd target


git init
git add clientRadisson-0.0.1-SNAPSHOT.jar
git commit
git remote add origin https://github.com/omarcury/clientRedisson.git
git pull origin master --allow-unrelated-histories
git push -u origin master
cd ..


#git config --global user.email "omarcury@gmail.com"
#git config --global user.name "omarcury"
