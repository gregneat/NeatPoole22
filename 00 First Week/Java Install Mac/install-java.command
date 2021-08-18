#!/bin/sh

# check if java installed
java -version
if [ $? -eq 0 ]; then
    echo "Java already installed"
else
    echo "Java not installed; proceeding to install java"
fi


# install xcode tools
xcode-select --install
if [ $? -eq 0 ]; then
    echo "Xcode tools installed successfuly"
else
    echo "Xcode tools not installed"
fi

# Install Homebrew if not installed; if installed, update.
which -s brew
if [[ $? != 0 ]] ; then
    # Install Homebrew
    ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"
else
    brew update
fi

# install cask
brew tap caskroom/cask
if [ $? -eq 0 ]; then
    echo "Cask installed successfuly"
else
    echo "Cask not installed"
fi

# install java
brew cask install java
if [ $? -eq 0 ]; then
    echo "Java cask installed successfuly"
else
    echo "Java cask not installed"
fi


# check installed
java -version
if [ $? -eq 0 ]; then
    echo "Java successfuly installed"
else
    echo "Java not installed"
fi

