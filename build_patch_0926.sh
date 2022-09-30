#!/bin/bash

cd ~/mw_ws
colcon build --packages-select service_manager
colcon build --packages-select hardware_manager
colcon build --packages-select message_bridge

