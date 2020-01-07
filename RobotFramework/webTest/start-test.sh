#!/bin/bash

export PATH=$PATH:../

python -m robot InvalidLogin.robot LogInAndLogOut.robot LoginSucces.robot InvalidPassword.robot
