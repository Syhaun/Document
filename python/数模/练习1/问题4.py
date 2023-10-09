import numpy as np


def objective_function(x, y, L):
    # Compute the centroid of the triangle
    centroid_x = np.mean(x)
    centroid_y = np.mean(y)

    # Compute the distance from each drone to the centroid
    d = np.sqrt((x - centroid_x) ** 2 + (y - centroid_y) ** 2)

    # Compute the angle of each drone with respect to the centroid
    theta = np.arctan2(y - centroid_y, x - centroid_x)

    # Compute the desired distance from each drone to the centroid
    d_desired = L / np.sqrt(3)

    # Compute the desired angle of each drone with respect to the centroid
    theta_desired = np.arange(0, 2 * np.pi, 2 * np.pi / 3)

    # Compute the deviation between the current and desired distance and angle
    deviation_d = np.sum((d - d_desired) ** 2)
    deviation_theta = np.min([np.sum((np.roll(theta, i) - theta_desired) ** 2) for i in range(3)])

    # Compute the total deviation
    deviation = deviation_d + deviation_theta

    return deviation
